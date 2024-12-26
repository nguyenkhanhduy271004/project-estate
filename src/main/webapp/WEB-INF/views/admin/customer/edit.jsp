<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Thêm tòa nhà</title>

</head>
<body>
<div class="main-content" id="main-container">
    <div class="main-content"
         style="font-family: 'Times New Roman', Times, serif; font-size: 1.4rem;">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                  try {
                    ace.settings.check('breadcrumbs', 'fixed')
                  } catch (e) {
                  }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Thông tin khách hàng

                    </h1>

                </div><!-- /.page-header -->
                <div class="row">
                    <form:form id="listForm" method="GET" modelAttribute="modalSearch">
                        <div class="col-xs-12">
                            <form class="form-horizontal" role="form" id="form-edit">
                                <div class="form-group">
                                    <div class="col-xs-3">Tên khách hàng</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="fullName"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Số điện thoại</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="phone"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Email</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="email"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Tên công ty</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="companyName"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Trạng thái</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="status"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3"></div>
                                    <div class="col-xs-6">
                                        <button class="btn btn-info"
                                                onclick="btnAddOrUpdateCustomer()">
                                            Cập nhật thông tin
                                        </button>
                                        <button class="btn btn-info" id="cancleBtn">Hủy thao tác
                                        </button>
                                    </div>
                                </div>
                                    <%--                                <form:hidden path="id" id="customerId"/>--%>
                            </form>
                        </div>
                    </form:form>
                </div>
                <c:forEach var="entry" items="${transactionTypes}">
                    <div class="row" style="margin-top: 20px">
                        <div class="col-xs-12" style="padding: 0!important;">
                            <h4 style="color: #2679b5">${entry.value}</h4>
                        </div>
                        <div class="col-xs-12" style="padding: 0!important;">
                            <hr style="background-color: #ccc; height: 1px; border: none;">
                        </div>
                        <div class="col-xs-12" style="padding: 0!important; margin-bottom: 10px">
                            <button class="btn btn-info"
                                    onclick="btnAddTransaction('${entry.key}')">
                                Add
                            </button>
                        </div>

                        <div class="row">
                            <div class="col-xs-12" bis_skin_checked="1">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Ngày tạo</th>
                                        <th>Người tạo</th>
                                        <th>Chi tiết giao dịch</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="transaction" items="${transactions}">
                                        <c:if test="${entry.key eq transaction.code}">
                                            <tr>
                                                <td>${transaction.createdDate}</td>
                                                <td>${transaction.createdBy}</td>
                                                <td>${transaction.note}</td>
                                                <td>
                                                    <button
                                                            class="btn btn-xs btn-info edit-transaction-btn"
                                                            data-note="${transaction.note}"
                                                            data-id="${transaction.id}">
                                                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                    </button>

                                                </td>
                                            </tr>
                                        </c:if>

                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.span -->
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->
<input type="hidden" id="transactionCode" value="">
<input type="hidden" id="customerId" value="${customerId}">
<script src="assets/js/jquery.2.1.1.min.js"></script>
<div class="modal fade" id="addTransactionModal" role="dialog"
     style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Nhập giao dịch</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12" style="display: flex; align-items: center;">
                        <div class="col-sm-3">
                            <label>Chi tiết giao dịch</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" value="" class="form-control"
                                   id="contentTransaction"/>
                        </div>
                    </div>
                </div>
                <%--                <input type="hidden" id="customerId" name="customerId" value="">--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary"
                        onclick="btnAddTransactionWithValue()">Thêm giao
                    dịch
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editTransactionModal" role="dialog"
     style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Nhập giao dịch</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12" style="display: flex; align-items: center;">
                        <div class="col-sm-3">
                            <label>Chi tiết giao dịch</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" value="" class="form-control"
                                   id="contentTransactionEdit"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="saveTransactionBtn">Sửa giao
                    dịch
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>


</div>
</div>
<script src="assets/js/jquery.2.1.1.min.js"></script>
<script>
  function btnAddTransaction(code) {
    $('#addTransactionModal').modal('show');
    $('#transactionCode').val(code);
  }

  function btnAddTransactionWithValue() {
    var data = {};
    data['customerId'] = $('#customerId').val();
    data['code'] = $('#transactionCode').val();
    data['note'] = $('#contentTransaction').val();
    $.ajax({
      type: 'POST',
      url: '${customerAPI}/transaction',
      data: JSON.stringify(data),
      contentType: 'application/json',
      dataType: 'json',
      success: function (response) {
        window.location.href = "/admin/customer-edit-" + $('#customerId').val()
            + "?success=success";
      },
      error: function (response) {
        window.location.href = "/admin/customer-edit-" + $('#customerId').val()
            + "?error=error";
      }
    });
  }

  function btnAddOrUpdateCustomer() {
    var data = {};
    var formData = $('#listForm').serializeArray();

    data["id"] = $('#customerId').val();

    $.each(formData, function (i, v) {
      data[v.name] = v.value;
    });

    $.ajax({
      type: "PUT",
      url: "${customerAPI}",
      data: JSON.stringify(data),
      contentType: "application/json",
      dataType: "json",
      success: function (response) {
        location.reload();
      },
      error: function (response) {
        location.reload();
      }
    })
  }

  $('.edit-transaction-btn').click(function () {
    var note = $(this).data('note');
    var id = $(this).data('id');

    $('#editTransactionModal').modal('show');
    $('#contentTransactionEdit').val(note);

    $('#saveTransactionBtn').click(function () {
      var data = {};
      data['id'] = id;
      data['customerId'] = $('#customerId').val();
      data['code'] = $('#transactionCode').val();
      data['note'] = $('#contentTransactionEdit').val();

      $.ajax({
        type: 'POST',
        url: '${customerAPI}/transaction',
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function (response) {
          alert("Cập nhật giao dịch thành công!");
          location.reload();
        },
        error: function (response) {
          location.reload()
        }
      });
    });

  });

  $('#cancleBtn').click(function (e) {
    e.preventDefault();
    window.location.href = "/admin/customer-list";
  })


</script>
</body>
</html>
