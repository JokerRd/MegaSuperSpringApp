
function click() {
    let objects = [{"name": "Иван", "age": 24}, {"name": "Петр", "age": 24}]
    const container = document.getElementById("container")
    const html = createListHtml(objects)
    container.innerHTML = html
    console.log(html)
}


function render(objects) {
    let liList = ''
    for (let object of objects) {
        liList += `<li>Имя: ${object.name}, Возраст: ${object.age}</li>`
    }
    const container = document.getElementById("container")
    const html = `
       <ol>
           ${liList}
       </ol>
    `
    container.innerHTML = html
}

let button = document.getElementById("test")
button.addEventListener('click', click)