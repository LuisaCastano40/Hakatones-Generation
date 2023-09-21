//Importamos los datos
import { productos } from "./data.js";

//Traemos los elementos necesarios del HTML
const productsContainer = document.getElementById('products');
const carrito = document.getElementById('cart');
const cerrar = document.getElementById('close');
const cartProd = document.getElementById('container-cartProd');
const btnBorrar = document.getElementById('btn-vaciar');

//Almaceno los productos existentes
let products = productos;
let carritoProducts = [];


carrito.addEventListener('click', abrirCarro);
cerrar.addEventListener('click', cerrarCarro);
btnBorrar.addEventListener('click',borrarCrrito);

document.addEventListener("DOMContentLoaded", () => {
    renderProducts();
    productsContainer.addEventListener('click', (event) => {
        if (event.target.classList.contains('btn-agregar')) {
        let idProduct = event.target.id;
        agregarCarrito(idProduct);
    }
    });
});


/*--------------------FUNCIONES-------------------------------*/

function renderProducts(){

    products.forEach((product) => {
        productsContainer.innerHTML += `
            <article class="cardProductos" id=${product.id}>
                <div class="container-producto">
                    <div class="card-image">
                        <img src="${product.imagen}" alt="producto-papeleria">
                    </div>
                    <div class="card-infoProducto">
                        <span>${product.categoria}</span>
                        <h3>${product.nombre}</h3>
                        <h4>$ ${product.precio}</h4>
                    </div>
                </div>
                <div class="container-btnAdd" id="btn-Add">
                    <button class="btn-agregar" id=${product.id}>
                        AGREGAR AL CARRITO
                        <i class='bx bx-cart-add'></i>
                    </button>
                </div>
            </article>`
    });
}


function abrirCarro(){
    const visible = document.querySelector('.active');
    visible.style.visibility = 'visible'
}

function cerrarCarro(){
    const visible = document.querySelector('.active');
    visible.style.visibility = 'hidden'
}

function agregarCarrito(id){
    console.log('holi funciono');

    products.forEach((product,idP) => {

        if(id == idP && (!carritoProducts.includes(product))){
            carritoProducts.push(product);
            renderCart();
            alert('Agregasté satisfactoriamente el producto');
        }else{
            if(id == idP){
                alert('Ya se agregó este producto al carrito');
            }
        }
    });
    actualizarEventosBotones();
}

function renderCart(){
    cartProd.innerHTML ='';
    carritoProducts.forEach(product => {
        cartProd.innerHTML += `
            <article class="cartProductos">
                <div class="producto">
                    <div class="cart-image">
                        <img src="${product.imagen}" alt="producto-papeleria">
                    </div>
                    <div class="cart-infoProducto">
                        <span>${product.categoria}</span>
                        <h3>${product.nombre}</h3>
                        <h4>$ ${product.precio}</h4>
                    </div>
                </div>
                <div class="accionesProducto">
                    <div class="cantidad">
                        <i class='bx bxs-up-arrow-circle btnSumar' id="${product.id}"></i>
                        <span id='cantidadResult'>1</span>
                        <i class='bx bxs-down-arrow-circle btnRestar' id="${product.id}"></i>
                    </div>
                    <i class='bx bxs-trash btnBorrar'></i>
                </div>
            </article>`
    });
}

function borrarCrrito(){
    cartProd.innerHTML = '';
    carritoProducts = [];
}

function actualizarEventosBotones() {
    const btnSumarCarrito = document.querySelectorAll('.btnSumar');
    const btnRestarCarrito = document.querySelectorAll('.btnRestar');
    const btnEliminar = document.querySelectorAll('.btnBorrar');

    btnSumarCarrito.forEach(button => {
        button.addEventListener('click', () => sumarProductoCarrito(button.id));
    });

    btnRestarCarrito.forEach(button => {
        button.addEventListener('click', () => restarProductoCarrito(button.id));
    });

    btnEliminar.forEach(button => {
        button.addEventListener('click', () => eliminarProductoCarrito(button.id));
    });
}

function sumarProductoCarrito(id) {
    const productoEnCarrito = carritoProducts.find(product => product.id == id);
    if (productoEnCarrito) {
        productoEnCarrito.cantidad++;
        const cantidadElement = document.querySelector(`.cartProductos[data-id="${id}"] .accionesProducto span`);
        cantidadElement.textContent = productoEnCarrito.cantidad;
    }
}

function restarProductoCarrito(id) {
    const productoEnCarrito = carritoProducts.find(product => product.id == id);
    if (productoEnCarrito && productoEnCarrito.cantidad > 1) {
        productoEnCarrito.cantidad--;
        const cantidadElement = document.querySelector(`.cartProductos[data-id="${id}"] .accionesProducto span`);
        cantidadElement.textContent = productoEnCarrito.cantidad;
    }
}

function eliminarProductoCarrito(id) {
     // Encuentra el índice del producto en el carrito usando el atributo data-id
     const indice = carritoProducts.findIndex(producto => producto.id == id);
    
     // Verifica si se encontró el producto
     if (indice !== -1) {
         // Elimina el producto del carrito
         carritoProducts.splice(indice, 1);
         
         // Vuelve a renderizar el carrito
         renderCart();
     }
}

// renderProducts();
