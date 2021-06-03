<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
        <div class="container">

            <form:form method="POST" modelAttribute="spending">
                <form:hidden path="id"/>

                <fieldset class="form-group">
                    <form:label path="desc">
                        Description
                    </form:label>
                    <form:input path="desc" type="text" class="form-control" required="required"/> 
                    <!-- required="required" is to make this field compulsory to key-->
                    <form:errors path="desc" cssClass="text-warning">

                    </form:errors>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="spendingDate">
                        Spending Date
                    </form:label>
                    <form:input path="spendingDate" type="text" class="form-control" required="required"/> 
                    <!-- required="required" is to make this field compulsory to key-->
                    <form:errors path="spendingDate" cssClass="text-warning">

                    </form:errors>
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="amount">
                        Amount
                    </form:label>
                    <form:input path="amount" type="double" class="form-control" required="required"/> 
                    <!-- required="required" is to make this field compulsory to key-->
                    <form:errors path="amount" cssClass="text-warning">

                    </form:errors>
                </fieldset>
                
                <button type="submit" class="btn btn-success">Add</button>
            </form:form>
        </div>

<%@ include file="common/footer.jspf" %>