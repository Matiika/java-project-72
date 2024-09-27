@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.util.DateFormatterUtil

@param UrlsPage page

@template.layout.page(
page = page,
content = @`
    <h1>Все адреса</h1>

    <table class="table table-bordered table-hover mt-3">
        <thead>
        <tr>
            <th class="col-1">ID</th>
            <th>Имя</th>
            <th class="col-2">Последняя проверка</th>
            <th class="col-1">Код ответа</th>
        </tr>
        </thead>
        <tbody>
        @for(var url : page.getUrls())
            <tr>
                <td>
                    ${url.getId()}
                </td>
                <td>
                    <a href="/urls/${url.getId()}">${url.getName()}</a>
                </td>
                @for(var check : page.getUrlChecks())
                    @if(check.getUrlId() == url.getId())
                        <td>
                            ${DateFormatterUtil.formatTimestamp(check.getCreatedAt())}
                        </td>
                        <td>
                            ${check.getStatusCode()}
                        </td>
                    @endif
                @endfor
            </tr>
        @endfor
        </tbody>
    </table>
`
)