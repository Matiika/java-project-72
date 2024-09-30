package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.util.DateFormatterUtil;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls/urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,23,23,26,26,26,29,29,29,29,29,29,29,31,31,32,32,34,34,34,37,37,37,39,39,40,40,42,42,47,47,47,47,47,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <main class=\"flex-grow-1\">\n    <section class=\"container-lg mt-5\">\n    <h1>Все адреса</h1>\n\n    <table class=\"table table-bordered table-hover mt-3\">\n        <thead>\n        <tr>\n            <th class=\"col-1\">ID</th>\n            <th>Имя</th>\n            <th class=\"col-2\">Последняя проверка</th>\n            <th class=\"col-1\">Код ответа</th>\n        </tr>\n        </thead>\n        <tbody>\n        ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getId());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    <a href=\"/urls/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(url.getId());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("</a>\n                </td>\n                ");
					for (var check : page.getUrlChecks()) {
						jteOutput.writeContent("\n                    ");
						if (check.getUrlId() == url.getId()) {
							jteOutput.writeContent("\n                        <td>\n                            ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(DateFormatterUtil.formatTimestamp(check.getCreatedAt()));
							jteOutput.writeContent("\n                        </td>\n                        <td>\n                            ");
							jteOutput.setContext("td", null);
							jteOutput.writeUserContent(check.getStatusCode());
							jteOutput.writeContent("\n                        </td>\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n        </tbody>\n    </table>\n    </section>\n    </main>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
