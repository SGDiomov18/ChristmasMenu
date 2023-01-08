<html>

<head>
    <title>Login Page</title>
</head>

<body>
<form action = "/" method="post">
        <label for="starters">Choose a starter:</label>
        <select name="starters" id="starters">
            <option>None</option>
            <c:forEach items="${starters}" var="starter">
                <option value=${starter.getClass.getSimpleName()}>${starter.getClass.getSimpleName()}</option>
            </c:forEach>
        </select>
        <input type="text" name="weightStarter">
        <br>

        <label for="mainCourse">Choose a team:</label>
        <select name="mainCourse" id="mainCourse">
            <option>None</option>
            <c:forEach items="${mainCourse}" var="food">
                <option value=${food.getClass.getSimpleName()}>${food.getClass.getSimpleName()}</option>
            </c:forEach>
        </select>
        <input type="text" name="weightMainCourse">
        <br>

        <label for="deserts">Choose a team:</label>
        <select name="deserts" id="deserts">
            <option>None</option>
            <c:forEach items="${deserts}" var="desert">
                <option value=${desert.getClass.getSimpleName()}>${desert.getClass.getSimpleName()}</option>
            </c:forEach>
        </select>
        <input type="text" name="weightDeserts">
        <br>

        <label for="beverages">Choose a team:</label>
        <select name="beverages" id="beverages">
            <option>None</option>
            <c:forEach items="${beverages}" var="beverage">
                <option value=${beverage.getClass.getSimpleName()}>${beverage.getClass.getSimpleName()}</option>
            </c:forEach>
        </select>
        <input type="text" name="weightBeverages">
        <br>

        <button type="submit" name="cancel" value="Cancel">Cancel</button>

</form>
</body>

</html>