<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:url var="deleteUrl" value="/api-admin-news"></c:url>
<html>
<head>
    <title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <form method="GET" action="<c:url value='/admin-news' />" id="formSubmit">
            <div class="page-content">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}">
                            ${message}
                    </div>
                </c:if>
                <div class="row" >
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <%--<div class="widget-body">--%>
                                <%--<div class="widget-main">--%>
                                    <%--<div class="form-horizontal">--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label class="col-sm-3 control-label no-padding-right">Tên bài viết</label>--%>
                                            <%--<div class="col-sm-9">--%>
                                                <%--<input type="text" id="title" name="title" class="form-control" value="${model.title}">--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label class="col-sm-3 control-label no-padding-right">Loại bài viết</label>--%>
                                            <%--<div class="col-sm-9">--%>
                                                <%--<select class="form-control" id="categoryCode" name="categoryCode">--%>
                                                    <%--<c:if test="${empty model.categoryCode}">--%>
                                                        <%--<option value="">Chọn loại bài viết</option>--%>
                                                        <%--<c:forEach var="item" items="${categories}">--%>
                                                            <%--<option value="${item.code}">${item.name}</option>--%>
                                                        <%--</c:forEach>--%>
                                                    <%--</c:if>--%>
                                                    <%--<c:if test="${not empty model.categoryCode}">--%>
                                                        <%--<option value="">Chọn loại bài viết</option>--%>
                                                        <%--<c:forEach var="item" items="${categories}">--%>
                                                            <%--<option value="${item.code}"--%>
                                                                    <%--<c:if test="${item.code == model.categoryCode}">--%>
                                                                        <%--selected="selected"--%>
                                                                    <%--</c:if>>--%>
                                                                    <%--${item.name}--%>
                                                            <%--</option>--%>
                                                        <%--</c:forEach>--%>
                                                    <%--</c:if>--%>
                                                <%--</select>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                        <%--<div class="form-group">--%>
                                            <%--<label class="col-sm-3 control-label no-padding-right"></label>--%>
                                            <%--<div class="col-sm-9">--%>
                                                <%--<button id="btnSearch" type="button" class="btn btn-sm btn-success">--%>
                                                    <%--Tìm kiếm--%>
                                                    <%--<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>--%>
                                                <%--</button>--%>
                                            <%--</div>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <br />
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                           title="Thêm bài viết" href='<c:url value="/admin-news?type=edit" />' >
                                            <span>
                                                <i class="fa fa-plus-circle bigger-110 purple"></i>
                                            </span>
                                        </a>
                                        <button id="btnDelete" type="button" disabled
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title="Xóa bài viết">
                                            <span>
                                                <i class="fa fa-trash-o bigger-110 pink"></i>
                                            </span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" class="check-box-element" id="checkAll"></th>
                                            <th>Ngày</th>
                                            <th>Tên Sản Phẩm</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lý</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T sàn</th>
                                            <th>D.T trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí MG</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${model.listResult}" var="item">
                                            <tr>
                                                <td><input type="checkbox" class="check-box-element" id="checkbox_${item.id}" value="${item.id}"></td>
                                                <td>${item.timeContract}</td>
                                                <td>${item.name}</td>
                                                <td>${item.street}, ${item.ward}, ${item.district}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.managerPhone}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.rentArea}</td>
                                                <td>${item.costRent}</td>
                                                <td>${item.serviceCost}</td>
                                                <td>${item.commission}</td>
                                                <td>
                                                    <c:url value="/admin-news" var="editURL">
                                                        <c:param name="type" value="edit" />
                                                        <c:param name="id" value="${item.id}" />
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhập bài viết" href="${editURL}">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" name="page" id="page" >
                                    <input type="hidden" value="" name="maxPageItem" id="maxPageItem" >
                                    <input type="hidden" value="" name="sortName" id="sortName" >
                                    <input type="hidden" value="" name="sortBy" id="sortBy" >
                                    <input type="hidden" value="" name="type" id="type" >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div><!-- /.main-content -->
<script type="text/javascript">
</script>
</body>
</html>
