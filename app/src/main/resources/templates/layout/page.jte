@import gg.jte.Content
@import hexlet.code.dto.BasePage

@param Content content
@param BasePage page = null
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<p>Анализатор сайтов</p>

@if(page == null)
    <p>Page == null</p>
@endif

@if(page != null && page.getFlash() != null)
    <p>Flash message: ${page.getFlash()}</p>
@else
    <p>No flash message</p>
@endif

${content}
</body>
</html>
