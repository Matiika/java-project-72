package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.BasePage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,7,7,39,39,39,39,39,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BasePage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <main class=\"flex-grow-1\">\n\n        <section>\n\n            <div class=\"container-fluid bg-dark p-5\">\n                <div class=\"row\">\n                    <div class=\"col-md-10 col-lg-8 mx-auto text-white\">\n                        <h1 class=\"display-3 mb-0\">Анализатор страниц</h1>\n                        <p class=\"lead\">Бесплатно проверяйте сайты на SEO пригодность</p>\n                        <form action=\"/urls\" method=\"post\" class=\"rss-form text-body\">\n                            <div class=\"row\">\n                                <div class=\"col\">\n                                    <div class=\"form-floating\">\n                                        <input id=\"url-input\" autofocus=\"\" type=\"text\" required=\"\" name=\"url\" aria-label=\"url\" class=\"form-control w-100\" placeholder=\"ссылка\" autocomplete=\"off\">\n                                        <label for=\"url-input\">Ссылка</label>\n                                    </div>\n                                </div>\n                                <div class=\"col-auto\">\n                                    <button type=\"submit\" class=\"h-100 btn btn-lg btn-primary px-sm-5\">Проверить</button>\n                                </div>\n                            </div>\n                        </form>\n                        <p class=\"mt-2 mb-0 text-muted\">Пример: https://www.example.com</p>\n                    </div>\n                </div>\n            </div>\n\n        </section>\n    </main>\n\n");
			}
		}, page);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BasePage page = (BasePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
