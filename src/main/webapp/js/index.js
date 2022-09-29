const form = document.querySelector("#form")
const button = document.querySelector("#submit")

button.addEventListener('click', () => {
    form.submit();
    console.log(form)
})