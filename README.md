// Chờ toàn bộ HTML tải xong rồi mới chạy code bên trong
document.addEventListener("DOMContentLoaded", function () {
  // Tìm nút hamburger menu (dùng cho mobile)
  var menuButton = document.querySelector(".menu-btn");
  // Tìm thanh điều hướng (navbar)
  var nav = document.querySelector(".nav");

  // Chỉ chạy nếu cả hai phần tử tồn tại trên trang
  if (menuButton && nav) {
    // Lắng nghe sự kiện click vào nút menu
    menuButton.addEventListener("click", function () {
      // Bật/tắt class "open" trên nav → hiện/ẩn menu mobile
      nav.classList.toggle("open");
    });
  }

  // Gọi hàm khởi tạo slider ảnh lớn ở đầu trang (hero banner)
  initHeroSlider();
  // Gọi hàm khởi tạo khu vực duyệt sản phẩm theo danh mục
  initCategoryBrowser();
  // Gọi hàm khởi tạo gallery ảnh trên trang chi tiết sản phẩm
  initDetailGallery();
  // Gọi hàm khởi tạo xử lý các form liên hệ
  initContactForms();
});

// ============================================================
// HÀM KHỞI TẠO SLIDER BANNER ĐẦU TRANG
// ============================================================
function initHeroSlider() {
  // Tìm phần tử chứa các slide (track là "đường ray" trượt)
  var sliderTrack = document.getElementById("hero-slider-track");
  // Tìm phần tử chứa các chấm điều hướng bên dưới slider
  var sliderDots = document.getElementById("hero-slider-dots");

  // Nếu không tìm thấy một trong hai → thoát hàm (trang không có slider)
  if (!sliderTrack || !sliderDots) {
    return;
  }

  // Mảng dữ liệu cho 3 slide banner: hạng sang, trung cấp, phổ thông
  var heroSlides = [
    {
      image: "../images/bannercaocap.png",      // Đường dẫn ảnh slide
      alt: "Banner xe điện hạng sang VoltRide", // Mô tả ảnh (accessibility)
      eyebrow: "Hạng sang",                     // Nhãn nhỏ phía trên tiêu đề
      title: "Dòng xe điện cao cấp cho người cần trải nghiệm êm, mạnh và sang.",
      description: "Thiết kế nổi bật, quãng đường dài và nhiều công nghệ hỗ trợ di chuyển mỗi ngày.",
      primaryLabel: "Xem xe hạng sang",         // Chữ nút CTA chính
      primaryHref: "./chi-tiet.html",            // Link nút CTA chính
      secondaryLabel: "Nhận báo giá",           // Chữ nút CTA phụ
      secondaryHref: "./lien-he.html"            // Link nút CTA phụ
    },
    {
      image: "../images/bannertrungcap.png",
      alt: "Banner xe điện trung cấp VoltRide",
      eyebrow: "Trung cấp",
      title: "Phân khúc trung cấp cân bằng giữa chi phí đầu tư và hiệu quả sử dụng.",
      description: "Phù hợp đi học, đi làm, giao nhận nhẹ trong đô thị với mức giá dễ tiếp cận hơn.",
      primaryLabel: "Khám phá trung cấp",
      primaryHref: "./san-pham.html",
      secondaryLabel: "Đăng ký lái thử",
      secondaryHref: "./lien-he.html"
    },
    {
      image: "../images/bannerphothong.png",
      alt: "Banner xe điện phổ thông VoltRide",
      eyebrow: "Phổ thông",
      title: "Mẫu xe điện phổ thông cho nhu cầu cơ bản, dễ mua và dễ sử dụng.",
      description: "Tối ưu cho học sinh, sinh viên và gia đình cần thêm một chiếc xe điện tiết kiệm.",
      primaryLabel: "Xem xe phổ thông",
      primaryHref: "./san-pham.html",
      secondaryLabel: "Xem ưu đãi",
      secondaryHref: "./khuyen-mai.html"
    }
  ];

  // Dùng .map() duyệt qua từng slide → tạo chuỗi HTML → gán vào sliderTrack
  sliderTrack.innerHTML = heroSlides
    .map(function (slide, index) {
      return (
        // Tạo thẻ <article> cho mỗi slide; slide đầu tiên có class "active"
        '<article class="hero-slide' + (index === 0 ? " active" : "") + '">' +
        // Ảnh nền của slide
        '<img src="' + slide.image + '" alt="' + slide.alt + '">' +
        // Lớp phủ tối lên ảnh để chữ dễ đọc hơn
        '<div class="hero-slide-overlay"></div>' +
        // Khối nội dung chữ bên trên ảnh
        '<div class="hero-slide-content">' +
        // Nhãn nhỏ phía trên tiêu đề (vd: "Hạng sang")
        '<span class="eyebrow eyebrow-light">' + slide.eyebrow + '</span>' +
        // Tiêu đề lớn của slide
        '<h1>' + slide.title + '</h1>' +
        // Mô tả ngắn
        '<p>' + slide.description + '</p>' +
        // Khối chứa 2 nút CTA
        '<div class="hero-actions">' +
        // Nút CTA chính (màu nổi)
        '<a class="btn btn-primary" href="' + slide.primaryHref + '">' + slide.primaryLabel + '</a>' +
        // Nút CTA phụ (viền trong suốt)
        '<a class="btn btn-outline hero-outline" href="' + slide.secondaryHref + '">' + slide.secondaryLabel + '</a>' +
        '</div>' +
        // Khối thống kê 3 chỉ số nổi bật (dùng chung cho mọi slide)
        '<div class="stats-grid hero-slide-stats">' +
        '<article><strong>120km</strong><span>Tầm di chuyển tối đa</span></article>' +
        '<article><strong>3 năm</strong><span>Bảo hành pin và động cơ</span></article>' +
        '<article><strong>0%</strong><span>Hỗ trợ trả góp mở bán</span></article>' +
        '</div>' +
        '</div>' +
        '</article>'
      );
    })
    .join(""); // Nối tất cả HTML lại thành một chuỗi duy nhất (không có ký tự ngăn cách)

  // Tạo HTML cho các chấm điều hướng bên dưới slider
  sliderDots.innerHTML = heroSlides
    .map(function (slide, index) {
      // Mỗi chấm là một <button>; chấm đầu tiên có class "active"
      return '<button class="hero-dot' + (index === 0 ? ' active' : '') + '" type="button" data-slide-index="' +
        index + '" aria-label="Chuyển banner ' + (index + 1) + '"></button>';
        // data-slide-index lưu số thứ tự slide để biết cần chuyển đến slide nào khi click
    })
    .join("");

  // Lấy lại toàn bộ các phần tử slide vừa được tạo vào DOM
  var slides = sliderTrack.querySelectorAll(".hero-slide");
  // Lấy lại toàn bộ các chấm điều hướng vừa tạo
  var dots = sliderDots.querySelectorAll(".hero-dot");
  // Biến theo dõi slide đang hiển thị (bắt đầu từ 0)
  var currentSlide = 0;
  // Biến lưu ID của bộ đếm tự động chạy (để có thể dừng/reset)
  var autoplayId = null;

  // Hàm chuyển đến slide theo chỉ số index
  function showSlide(index) {
    // Cập nhật biến slide hiện tại
    currentSlide = index;

    // Duyệt qua tất cả slide: thêm "active" nếu đúng index, xóa nếu không
    slides.forEach(function (slide, slideIndex) {
      slide.classList.toggle("active", slideIndex === index);
    });

    // Duyệt qua tất cả chấm: thêm "active" cho chấm tương ứng
    dots.forEach(function (dot, dotIndex) {
      dot.classList.toggle("active", dotIndex === index);
    });
  }

  // Hàm reset (khởi động lại) bộ đếm tự động chuyển slide
  function resetAutoplay() {
    // Nếu đang có bộ đếm cũ → xóa đi để tránh chạy song song
    if (autoplayId) {
      window.clearInterval(autoplayId);
    }

    // Tạo bộ đếm mới: cứ 4000ms (4 giây) thì chuyển sang slide tiếp theo
    autoplayId = window.setInterval(function () {
      // Tính chỉ số slide tiếp theo; nếu là slide cuối thì quay lại slide đầu
      var nextIndex = (currentSlide + 1) % slides.length;
      showSlide(nextIndex);
    }, 4000);
  }

  // Gắn sự kiện click cho từng chấm điều hướng
  dots.forEach(function (dot) {
    dot.addEventListener("click", function () {
      // Lấy chỉ số slide từ thuộc tính data-slide-index, ép kiểu sang số
      var nextIndex = Number(dot.dataset.slideIndex);
      // Chuyển đến slide tương ứng
      showSlide(nextIndex);
      // Reset autoplay để tránh chuyển slide ngay sau khi vừa click
      resetAutoplay();
    });
  });

  // Hiển thị slide đầu tiên khi trang vừa load
  showSlide(0);
  // Bắt đầu chạy tự động
  resetAutoplay();
}

// ============================================================
// HÀM KHỞI TẠO KHU VỰC DUYỆT SẢN PHẨM THEO DANH MỤC
// ============================================================
function initCategoryBrowser() {
  // Tìm phần tử chứa các tab danh mục (Hạng sang / Trung cấp / Phổ thông)
  var tabsRoot = document.getElementById("category-tabs");
  // Tìm phần tử hiển thị sản phẩm nổi bật đang được chọn
  var featureRoot = document.getElementById("category-feature");
  // Tìm phần tử chứa danh sách các card sản phẩm nhỏ để chọn
  var productsRoot = document.getElementById("category-products");

  // Nếu thiếu bất kỳ phần tử nào → thoát (trang này không có section này)
  if (!tabsRoot || !featureRoot || !productsRoot) {
    return;
  }

  // Dữ liệu toàn bộ sản phẩm chia theo 3 danh mục
  var productCategories = [
    {
      label: "Hạng sang",       // Tên hiển thị trên tab
      tagClass: "tag",          // Class CSS cho nhãn tag màu mặc định
      products: [
        {
          name: "VoltRide S Ultra Black",  // Tên sản phẩm
          tag: "Hạng sang",               // Nhãn hiển thị trên card
          image: "../images/xecaocap.png", // Ảnh sản phẩm
          price: "32.990.000đ",            // Giá
          desc: "Bản màu đen bóng dành cho khách thích vẻ ngoài mạnh và sang trọng.",
          bullets: ["Pin Lithium 72V", "Quãng đường 120km", "Màn hình TFT cao cấp"] // Điểm nổi bật
        },
        {
          name: "VoltRide S Ultra Graphite",
          tag: "Hạng sang",
          image: "../images/xecaocap1.png",
          price: "33.490.000đ",
          desc: "Biến thể sắc xám hiện đại, hợp phong cách doanh nhân và đi làm hàng ngày.",
          bullets: ["Phanh đĩa trước sau", "Đèn LED projector", "Yên ngồi dày cao cấp"]
        },
        {
          name: "VoltRide S Ultra Copper",
          tag: "Hạng sang",
          image: "../images/caocap2.png",
          price: "33.990.000đ",
          desc: "Phiên bản phối màu nổi bật cho khách cần chiếc xe điện có điểm nhấn thị giác rõ ràng.",
          bullets: ["Thiết kế premium", "Khóa thông minh", "Khung xe chắc chắn"]
        }
      ]
    },
    {
      label: "Trung cấp",
      tagClass: "tag tag-blue", // Tag màu xanh cho danh mục trung cấp
      products: [
        {
          name: "VoltRide M City Navy",
          tag: "Trung cấp",
          image: "../images/xetrungcap.png",
          price: "21.490.000đ",
          desc: "Mẫu trung cấp đa dụng dành cho lịch trình đi học, đi làm và giao hàng nhẹ.",
          bullets: ["Quãng đường 90km", "Cốp rộng 22L", "Chống nước IP67"]
        },
        {
          name: "VoltRide M City White",
          tag: "Trung cấp",
          image: "../images/trungcap1.png",
          price: "21.790.000đ",
          desc: "Biến thể sáng màu cho người thích tổng thể gọn gàng, thanh lịch và trẻ trung.",
          bullets: ["Động cơ tiết kiệm điện", "Yên thấp dễ lái", "Thích hợp đi phố"]
        },
        {
          name: "VoltRide M City Red",
          tag: "Trung cấp",
          image: "../images/trungcap2.png",
          price: "21.990.000đ",
          desc: "Bản phối màu nổi bật cho khách cần xe điện cá tính nhưng vẫn cân bằng giá và tính năng.",
          bullets: ["Sạc đầy 5.5 giờ", "Khung sườn chịu lực tốt", "Đề pa mượt"]
        }
      ]
    },
    {
      label: "Phổ thông",
      tagClass: "tag tag-soft", // Tag màu nhạt cho danh mục phổ thông
      products: [
        {
          name: "VoltRide Go Mint",
          tag: "Phổ thông",
          image: "../images/xephothong.png",
          price: "14.990.000đ",
          desc: "Mẫu xe phổ thông phù hợp học sinh, sinh viên hoặc gia đình cần xe thứ hai tiết kiệm.",
          bullets: ["Quãng đường 65km", "Sạc trong 6 giờ", "Chiều cao yên thân thiện"]
        },
        {
          name: "VoltRide Go Silver",
          tag: "Phổ thông",
          image: "../images/xephothong2.png",
          price: "15.290.000đ",
          desc: "Biến thể trung tính dễ dùng, hợp nhu cầu đi học, đi chợ và di chuyển gần mỗi ngày.",
          bullets: ["Pin tháo rời", "Đèn LED tiết kiệm điện", "Bảo trì đơn giản"]
        }
      ]
    }
  ];

  // Biến lưu danh mục đang được chọn (0 = Hạng sang)
  var currentCategoryIndex = 0;
  // Biến lưu sản phẩm đang được chọn trong danh mục (0 = sản phẩm đầu tiên)
  var currentProductIndex = 0;

  // Hàm render (vẽ lại) các tab danh mục
  function renderTabs() {
    // Tạo HTML cho từng tab, tab đang chọn có class "active"
    tabsRoot.innerHTML = productCategories
      .map(function (category, index) {
        return '<button class="category-tab' + (index === currentCategoryIndex ? ' active' : '') +
          '" type="button" data-category-index="' + index + '">' + category.label + '</button>';
      })
      .join("");

    // Gắn sự kiện click cho từng tab vừa tạo
    tabsRoot.querySelectorAll(".category-tab").forEach(function (tab) {
      tab.addEventListener("click", function () {
        // Cập nhật danh mục đang chọn theo index lấy từ data attribute
        currentCategoryIndex = Number(tab.dataset.categoryIndex);
        // Reset về sản phẩm đầu tiên của danh mục mới
        currentProductIndex = 0;
        // Vẽ lại toàn bộ khu vực browser
        renderCategoryBrowser();
      });
    });
  }

  // Hàm render khung sản phẩm nổi bật (bên trái/trên, hiển thị chi tiết sản phẩm đang chọn)
  function renderFeature() {
    // Lấy danh mục đang chọn
    var category = productCategories[currentCategoryIndex];
    // Lấy sản phẩm đang chọn trong danh mục đó
    var product = category.products[currentProductIndex];

    // Tạo HTML cho khung feature gồm ảnh lớn + thông tin chi tiết
    featureRoot.innerHTML =
      // Khối ảnh lớn bên trái
      '<div class="category-feature-media">' +
      '<img src="' + product.image + '" alt="' + product.name + '">' +
      '</div>' +
      // Khối nội dung chữ bên phải
      '<div class="category-feature-copy">' +
      // Nhãn tag danh mục (vd: "Hạng sang")
      '<span class="' + category.tagClass + '">' + product.tag + '</span>' +
      // Tên sản phẩm
      '<h3>' + product.name + '</h3>' +
      // Mô tả sản phẩm
      '<p>' + product.desc + '</p>' +
      // Danh sách các điểm nổi bật dạng bullet
      '<ul class="feature-list">' +
      product.bullets.map(function (bullet) {
        return '<li>' + bullet + '</li>'; // Mỗi điểm nổi bật thành 1 <li>
      }).join("") +
      '</ul>' +
      // Hàng hiển thị giá + link chi tiết
      '<div class="price-row">' +
      '<strong>' + product.price + '</strong>' +         // Giá in đậm
      '<a href="./chi-tiet.html">Xem chi tiết</a>' +    // Link đến trang chi tiết
      '</div>' +
      '</div>';
  }

  // Hàm render danh sách card sản phẩm nhỏ để người dùng chọn
  function renderProducts() {
    // Lấy danh mục hiện tại
    var category = productCategories[currentCategoryIndex];

    // Tạo HTML cho từng card sản phẩm; card đang chọn có class "active"
    productsRoot.innerHTML = category.products
      .map(function (product, index) {
        return '<button class="product-choice-card card' + (index === currentProductIndex ? ' active' : '') +
          '" type="button" data-product-index="' + index + '">' +
          // Khối ảnh nhỏ bên trái card
          '<span class="product-choice-media"><img src="' + product.image + '" alt="' + product.name + '"></span>' +
          // Khối text: tag + tên + giá
          '<span class="product-choice-body">' +
          '<span class="' + category.tagClass + '">' + product.tag + '</span>' +
          '<strong>' + product.name + '</strong>' +
          '<small>' + product.price + '</small>' +
          '</span>' +
          '</button>';
      })
      .join("");

    // Gắn sự kiện click cho từng card sản phẩm vừa tạo
    productsRoot.querySelectorAll(".product-choice-card").forEach(function (card) {
      card.addEventListener("click", function () {
        // Cập nhật sản phẩm đang chọn theo index từ data attribute
        currentProductIndex = Number(card.dataset.productIndex);
        // Chỉ cần vẽ lại feature và danh sách card (không cần vẽ lại tab)
        renderFeature();
        renderProducts();
      });
    });
  }

  // Hàm tổng hợp: vẽ lại toàn bộ khu vực duyệt danh mục
  function renderCategoryBrowser() {
    renderTabs();      // Vẽ tabs
    renderFeature();   // Vẽ khung sản phẩm nổi bật
    renderProducts();  // Vẽ danh sách card nhỏ
  }

  // Khởi chạy lần đầu khi trang load
  renderCategoryBrowser();
}

// ============================================================
// HÀM KHỞI TẠO GALLERY ẢNH TRANG CHI TIẾT SẢN PHẨM
// ============================================================
function initDetailGallery() {
  // Lấy tất cả ảnh thumbnail (ảnh nhỏ phía dưới)
  var thumbs = document.querySelectorAll(".thumb");
  // Lấy phần tử ảnh lớn chính
  var mainPhoto = document.getElementById("anh-lon");

  // Duyệt qua từng thumbnail để gắn sự kiện
  thumbs.forEach(function (thumb) {
    thumb.addEventListener("click", function () {
      // Xóa class "active" khỏi tất cả thumbnail trước
      thumbs.forEach(function (item) {
        item.classList.remove("active");
      });

      // Thêm "active" cho thumbnail vừa được click (viền highlight)
      thumb.classList.add("active");

      // Nếu ảnh lớn tồn tại → cập nhật src và alt cho ảnh lớn
      if (mainPhoto) {
        mainPhoto.src = thumb.dataset.full;  // Lấy đường dẫn ảnh full từ data-full
        mainPhoto.alt = thumb.dataset.alt;   // Lấy mô tả ảnh từ data-alt
      }
    });
  });
}

// ============================================================
// HÀM KHỞI TẠO XỬ LÝ FORM LIÊN HỆ
// ============================================================
function initContactForms() {
  // Lấy tất cả form liên hệ trên trang (có thể có nhiều form)
  const forms = document.querySelectorAll(".contact-form");

  // Regex kiểm tra họ tên: chấp nhận chữ cái Latin, tiếng Việt, khoảng trắng, dấu nháy, gạch nối; 2-100 ký tự
  const nameRegex = /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\s'-]{2,100}$/i;

  // Regex kiểm tra số điện thoại Việt Nam: bắt đầu bằng 0 hoặc +84, theo sau là 9-10 chữ số
  const phoneRegex = /^(\+84|0)[1-9]\d{8,9}$/;

  // Regex kiểm tra địa chỉ: chấp nhận chữ, số, tiếng Việt và ký tự đặc biệt thông thường; 10-300 ký tự
  const addressRegex = /^[\w\sÀ-ỹ,.\-/#()']{10,300}$/u;

  // Duyệt qua từng form để gắn xử lý
  forms.forEach(form => {
    // Tìm phần tử hiển thị trạng thái sau khi submit (thành công / lỗi)
    const status = form.querySelector(".form-status");

    // Lắng nghe sự kiện submit của form
    form.addEventListener("submit", e => {
      // Ngăn form tự reload trang (hành vi mặc định của HTML form)
      e.preventDefault();

      // Xóa tất cả thông báo lỗi cũ trước khi validate lại
      form.querySelectorAll(".error-msg").forEach(el => el.remove());

      // Cờ theo dõi toàn bộ form có hợp lệ không
      let valid = true;

      // --- Kiểm tra trường Họ tên ---
      // Tìm input họ tên theo nhiều cách đặt tên có thể có
      const name = form.querySelector('input[name="hoten"], input[name="name"], #hoten, #name');
      // Nếu tìm thấy input và giá trị không khớp regex → báo lỗi
      if (name && !nameRegex.test(name.value.trim())) {
        showError(name, "Họ tên không hợp lệ");
        valid = false; // Đánh dấu form không hợp lệ
      }

      // --- Kiểm tra trường Số điện thoại ---
      const phone = form.querySelector('input[name="sodienthoai"], input[name="phone"], #sodienthoai, #phone');
      if (phone && !phoneRegex.test(phone.value.trim())) {
        showError(phone, "SĐT không hợp lệ (0 hoặc +84)");
        valid = false;
      }

      // --- Kiểm tra trường Địa chỉ ---
      const address = form.querySelector('input[name="diachi"], textarea[name="diachi"], #diachi');
      if (address && !addressRegex.test(address.value.trim())) {
        showError(address, "Địa chỉ phải 10-300 ký tự");
        valid = false;
      }

      // Nếu tất cả trường đều hợp lệ
      if (valid) {
        // Hiển thị thông báo thành công
        if (status) status.textContent = "✅ Đã ghi nhận!";
        // Sau 1.5 giây: reset form về trạng thái ban đầu và xóa thông báo
        setTimeout(() => { form.reset(); if (status) status.textContent = ""; }, 1500);
      }
    });
  });

  // Hàm hiển thị thông báo lỗi bên dưới input bị lỗi
  function showError(input, msg) {
    // Tạo thẻ <div> mới để chứa thông báo lỗi
    const err = document.createElement("div");
    // Gán class để nhận diện (dùng khi xóa lỗi cũ ở lần submit sau)
    err.className = "error-msg";
    // Màu chữ đỏ
    err.style.color = "#d32f2f";
    // Cỡ chữ nhỏ
    err.style.fontSize = "13px";
    // Khoảng cách trên nhỏ để tách khỏi input
    err.style.marginTop = "4px";
    // Nội dung thông báo lỗi
    err.textContent = msg;
    // Chèn thẻ lỗi vào sau input (vào trong thẻ cha của input)
    input.parentNode.appendChild(err);
    // Đổi màu viền input thành đỏ để người dùng nhận biết trường bị lỗi
    input.style.borderColor = "#d32f2f";
  }
}
