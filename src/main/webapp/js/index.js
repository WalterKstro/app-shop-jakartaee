const form = document.querySelector("#form")
const button = document.querySelector("#submit")

button.addEventListener('click', (event) => {
    event.preventDefault();
    form.submit();
})