//Tienda Ver Stock bnt
function incrementValue(button) {
    let input = button.previousElementSibling;
    let maxValue = parseInt(input.max);
    let currentValue = parseInt(input.value);

    if (currentValue < maxValue) {
        input.value = currentValue + 1;
    }
}

//Tienda Ver Stock bnt
function decrementValue(button) {
    let input = button.nextElementSibling;
    let minValue = parseInt(input.min);
    let currentValue = parseInt(input.value);

    if (currentValue > minValue) {
        input.value = currentValue - 1;
    }
}

//Ver Imagen
function previewImage() {
    var preview = document.getElementById("preview");
    var file = document.querySelector("input[type=file]").files[0];
    var reader = new FileReader();
    reader.onloadend = function () {
        preview.src = reader.result;
    };
    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "#";
    }
}

//Admin msj eliminar
const eliminarLinks = document.querySelectorAll('[id^="eliminar-"]');
eliminarLinks.forEach(eliminarLink => {
    eliminarLink.addEventListener('click', e => {
        e.preventDefault();
        const confirmacion = confirm('¿Estás seguro/a de que deseas eliminar?');
        if (confirmacion) {
            window.location.href = eliminarLink.getAttribute('href');
        }
    });
});

//hamburger nav
document.addEventListener("DOMContentLoaded", function () {
  document.querySelector(".hamburger").addEventListener("click", function () {
    this.classList.toggle("is-active");
    document.querySelector(".nav-list").classList.toggle("active");
  });
});


