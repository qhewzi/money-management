<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
            <div class="container">

                <h1>Edit ${budget.category}'s Budget</h1>

        <form:form method="POST" modelAttribute="budget">
            <form:hidden path="user"/>
            <form:hidden path="category"/>

        <fieldset class="form-group">
            <form:label path="amount">
                Amount
            </form:label>
            <form:input path="amount" type="double" class="form-control" required="required"/>
            <form:errors path="amount" cssClass="text-warning">

            </form:errors>
        </fieldset>

                <button type="submit" class="btn btn-success">Edit</button>
            </form:form>
        </div>

<%@ include file="common/footer.jspf" %>