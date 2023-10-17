export const updateCart = () => {
    const form = document.querySelector("#form")
    const buttonSubmit = document.querySelector("#submit")

    buttonSubmit.addEventListener('click', (event) => {
        event.preventDefault();
        form.submit();
    })
}