const btnRegister = document.getElementById('btn-register')
const username = document.getElementById('username')
const name = document.getElementById('name')
const phonenumber = document.getElementById('phonenumber')
const password = document.getElementById('password')
const confirmPassword = document.getElementById('confirmpassword')

btnRegister.addEventListener('click', () => {
    const data = {
        "username": username.value,
        "name": name.value,
        "phone": phonenumber.value,
        "password": password.value,
    }

    register(data)
})

async function register(data) {
    const url = "http://localhost:8082/register"
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })

        const res = await response.json();

        if(res.statusCode == 0) {
            window.location.href = "/login"
        } else {
            window.location.href = "/register"
        }
    } catch (error) {
        console.log('Co loi ', error)
        window.location.href = "/register"
    }
}