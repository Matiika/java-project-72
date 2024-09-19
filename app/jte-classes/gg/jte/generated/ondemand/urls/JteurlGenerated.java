package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlPage;
public final class JteurlGenerated {
	public static final String JTE_NAME = "urls/url.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,7,7,8,8,8,16,16,16,24,24,24,32,32,32,36,36,36,36,36,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
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
				jteOutput.writeContent("\n            </td>\n        </tr>\n    </table>\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
