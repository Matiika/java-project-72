@import hexlet.code.dto.urls.UrlsPage

@param UrlsPage page

@template.layout.page(
content = @`
    <h1>Все товары</h1>
    <table class="table table-striped">
        @for(var url : page.getUrls())
            <tr>
                <td>
                    ${url.getName()}
                </td>
            </tr>
        @endfor
    </table>
`
)