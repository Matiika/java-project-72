package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlChecksPage;
import hexlet.code.util.DateFormatterUtil;
public final class JteurlGenerated {
	public static final String JTE_NAME = "urls/url.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,8,8,9,9,9,17,17,17,25,25,25,33,33,33,38,38,38,38,52,52,55,55,55,58,58,58,61,61,61,64,64,64,67,67,67,70,70,70,73,73,77,77,77,77,77,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlChecksPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\n\n    <table class=\"table table-striped\">\n        <tr>\n            <td>\n                ID\n            </td>\n            <td>\n                ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("\n            </td>\n        </tr>\n        <tr>\n            <td>\n                Имя\n            </td>\n            <td>\n                ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("\n            </td>\n        </tr>\n        <tr>\n            <td>\n                Дата создания\n            </td>\n            <td>\n                ");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getCreatedAt().toString());
				jteOutput.writeContent("\n            </td>\n        </tr>\n    </table>\n    <h2>Проверки</h2>\n    <form method=\"post\" action=\"/urls/");
				jteOutput.setContext("form", "action");
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.setContext("form", null);
				jteOutput.writeContent("/checks\">\n        <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\n    </form>\n    <table class=\"table table-bordered table-hover mt-3\">\n        <thead>\n        <tr><th class=\"col-1\">ID</th>\n            <th class=\"col-1\">Код ответа</th>\n            <th>title</th>\n            <th>h1</th>\n            <th>description</th>\n            <th class=\"col-2\">Дата проверки</th>\n        </tr></thead>\n        <tbody>\n\n        ");
				for (var check : page.getUrlChecks()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getId());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getStatusCode());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getTitle());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getH1());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(check.getDescription());
					jteOutput.writeContent("\n                </td>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(DateFormatterUtil.formatTimestamp(check.getCreatedAt()));
					jteOutput.writeContent("\n                </td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n\n        </tbody>\n    </table>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlChecksPage page = (UrlChecksPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
