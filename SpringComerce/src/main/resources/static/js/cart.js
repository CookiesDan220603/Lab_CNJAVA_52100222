const btnCart = document.querySelector('.btn-add-cart')
const inputQuantity = document.getElementById('cart_quantity')

btnCart.addEventListener('click', () => {
    let id = btnCart.getAttribute('id').substring(1)
    let quantity = inputQuantity.value;

    const data = {
        "id": id,
        "quantity": Number.parseInt(quantity)
    }

    addProductIntoCart(data)

})

async function addProductIntoCart(data) {
    const url = "http://localhost:8082/cart/save";

    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })

        const res = await response.json();
        console.log(res)
        window.location.href = "/cart"
    } catch (error) {
        console.log('Co loi ', error)
    }
}

