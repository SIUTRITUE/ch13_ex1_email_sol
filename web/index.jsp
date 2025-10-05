<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>📧 Email List - Modern Web App</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,400&family=Nunito:ital,wght@0,300;0,400;0,600;0,700;0,800;1,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<div class="container">
    <h1>📧 Đăng ký Email List</h1>
    <p style="text-align: center; font-size: 1.1rem; margin-bottom: 2rem;">
        Đăng ký để nhận thông tin mới nhất từ chúng tôi
    </p>
    <div class="success-message" style="display: ${empty message ? 'none' : 'block'};">
        <p><i>${message}</i></p>
    </div>
    
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">        
        
        <div class="form-group">
            <label for="email">📧 Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" 
                   placeholder="Nhập email của bạn..." required>
        </div>
        
        <div class="form-group">
            <label for="firstName">👤 Họ:</label>
            <input type="text" id="firstName" name="firstName" value="${user.firstName}" 
                   placeholder="Nhập họ của bạn..." required>
        </div>
        
        <div class="form-group">
            <label for="lastName">👤 Tên:</label>
            <input type="text" id="lastName" name="lastName" value="${user.lastName}" 
                   placeholder="Nhập tên của bạn..." required>
        </div>
        
        <div class="text-center">
            <input type="submit" value="📧 Đăng ký ngay">
        </div>
    </form>
</div>

</body>
</html>