<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
            <div class="container">

                <h1>Your Spendings</h1>

                <table class="table table-striped">
                    <caption>
                        Your spendings are
                    </caption>
                    <!-- tr is header row and th is the header name -->
                    <thead>
                        <tr>
                            <th>
                                Description
                            </th>
                            <th>
                                Spending Date
                            </th>
                            <th>
                                Amount
                            </th>
                            <th>
                                Update
                            </th>
                            <th>
                                Delete
                            </th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${spendings}" var="spending">
                            <tr>
                                <td>
                                    ${spending.desc}
                                </td>
                                <td>
                                    <fmt:formatDate value="${spending.spendingDate}" pattern="dd/MM/yyyy" />
                                </td>
                                <td>
                                    ${spending.getAmount()}
                                </td>
                                <td>
                                    <a type="button" class="btn btn-success" href="/update-spending?id=${spending.id}">
                                        Update
                                    </a>
                                </td>
                                <td>
                                    <a type="button" class="btn btn-warning" href="/delete-spending?id=${spending.id}">
                                        DELETE
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

                <div>

                    <a class="button" href="/add-spending">
                        Add a spending
                    </a>

                </div>

            </div>

<%@ include file="common/footer.jspf" %>