<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
            <div class="container">

                <h1>Your Budgets</h1>

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                Category
                            </th>
                            <th>
                                Amount
                            </th>
                            <th>
                                Changes
                            </th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${budgets}" var="budget">
                            <tr>
                                <td>
                                    ${budget.category}
                                </td>
                                <td>
                                    ${budget.amount}
                                </td>
                                <td>
                                    <a type="button" class="btn btn-success" href="/edit-budget?category=${budget.category}&user=${budget.user}">
                                        Edit
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

            </div>

<%@ include file="common/footer.jspf" %>