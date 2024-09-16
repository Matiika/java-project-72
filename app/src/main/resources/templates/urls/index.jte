@template.layout.page(
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