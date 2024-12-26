<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="customerAPI" value="/api/customer"/>
<html>
<head>
    <title>Chỉnh sửa thông tin</title>

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
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Thêm khách hàng</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        Thông tin khách hàng
                    </h1>

                </div><!-- /.page-header -->
                <div class="row">
                    <form:form modelAttribute="customerForm" id="listForm" method="GET">
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
                                    <div class="col-xs-3">Nhu cầu</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="demand"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3">Tình trạng</div>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="status"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-3"></div>
                                    <div class="col-xs-6">
                                        <button class="btn btn-info"
                                                id="btnAddOrUpdateCustomer">
                                            Thêm khách hàng
                                        </button>
                                        <button class="btn btn-info" id="cancleBtn">Hủy thao tác
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="assets/js/jquery.2.1.1.min.js"></script>

<script>
  $('#btnAddOrUpdateCustomer').click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $('#listForm').serializeArray();

    $.each(formData, function (i, v) {
      data[v.name] = v.value;
    });

    if (data['fullName'] != '' && data['phone'] != '') {
      addOrUpdateCustomer(data);
    } else {
      window.location.href = "<c:url value="/admin/customer-add?fullName=required&phone=required"/>";
    }
  });

  function addOrUpdateCustomer(data) {
    $.ajax({
      type: "POST",
      url: "${customerAPI}",
      data: JSON.stringify(data),
      contentType: "application/json",
      dataType: "json",
      success: function (response) {
        window.location.href = "<c:url value="/admin/customer-list"/>";
      },
      error: function (response) {
        window.location.href = "<c:url value="/admin/customer-add?error=error"/>";
      }
    })
  }

  $('#cancleBtn').click(function (e) {
    e.preventDefault();
    window.location.href = "<c:url value="/admin/building-list"/>";
  });
</script>
</body>
</html>
