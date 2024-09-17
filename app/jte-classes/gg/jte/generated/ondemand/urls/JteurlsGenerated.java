package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlsPage;
public final class JteurlsGenerated {
	public static final String JTE_NAME = "urls/urls.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,6,6,8,8,9,9,9,10,10,12,12,15,15,15,18,18,20,20,20,20,20,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Все товары</h1>\n    ");
				if (page.getFlash() != null) {
					jteOutput.writeContent("\n        <p>Flash message: ");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("</p>\n    ");
				}
				jteOutput.writeContent("\n    <table class=\"table table-striped\">\n        ");
				for (var url : page.getUrls()) {
					jteOutput.writeContent("\n            <tr>\n                <td>\n                    ");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(url.getName());
					jteOutput.writeContent("\n                </td>\n            </tr>\n        ");
				}
				jteOutput.writeContent("\n    </table>\n");
			}
		}, null);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
