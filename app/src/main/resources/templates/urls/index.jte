@import hexlet.code.dto.BasePage

@param BasePage page

@template.layout.page(
    page = page,
content = @`
       <form action="/urls" method="post">
        <div>
            Введите адрес сайта
            <input type="text" name="url">
        </div>
        <input type="submit" value="Добавить">
    </form>
`
)