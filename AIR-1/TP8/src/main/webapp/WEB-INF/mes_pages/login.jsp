<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Gestion Congés</title>
    
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <!-- Custom CSS -->
    <style>
        :root {
            --primary-color: #2c3e50;
            --secondary-color: #3498db;
            --accent-color: #e74c3c;
            --light-bg: #f8f9fa;
            --success-color: #27ae60;
            --danger-color: #e74c3c;
        }
        
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }
        
        .login-card {
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            overflow: hidden;
            width: 100%;
            max-width: 420px;
            animation: fadeIn 0.6s ease-out;
        }
        
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        
        .login-header {
            background: linear-gradient(to right, var(--primary-color), var(--secondary-color));
            color: white;
            padding: 30px;
            text-align: center;
        }
        
        .login-header h2 {
            margin: 0;
            font-weight: 600;
            font-size: 1.8rem;
        }
        
        .login-header p {
            opacity: 0.9;
            margin: 5px 0 0 0;
            font-size: 0.95rem;
        }
        
        .login-body {
            padding: 30px;
        }
        
        .form-group {
            margin-bottom: 1.5rem;
        }
        
        .form-label {
            font-weight: 600;
            color: var(--primary-color);
            margin-bottom: 0.5rem;
            display: flex;
            align-items: center;
            gap: 8px;
        }
        
        .form-control {
            border: 2px solid #e1e5eb;
            border-radius: 8px;
            padding: 12px 15px;
            transition: all 0.3s;
            font-size: 1rem;
        }
        
        .form-control:focus {
            border-color: var(--secondary-color);
            box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.2);
        }
        
        .input-group-text {
            background-color: #f8f9fa;
            border: 2px solid #e1e5eb;
            border-right: none;
        }
        
        .btn-login {
            background: linear-gradient(to right, var(--secondary-color), var(--primary-color));
            color: white;
            border: none;
            border-radius: 8px;
            padding: 14px;
            font-weight: 600;
            font-size: 1rem;
            width: 100%;
            transition: all 0.3s;
            margin-top: 10px;
        }
        
        .btn-login:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        
        .alert {
            border-radius: 8px;
            border: none;
            padding: 15px;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            gap: 12px;
        }
        
        .alert-danger {
            background-color: rgba(231, 76, 60, 0.1);
            color: var(--danger-color);
            border-left: 4px solid var(--danger-color);
        }
        
        .alert-success {
            background-color: rgba(39, 174, 96, 0.1);
            color: var(--success-color);
            border-left: 4px solid var(--success-color);
        }
        
        .alert i {
            font-size: 1.2rem;
        }
        
        .footer-links {
            text-align: center;
            margin-top: 25px;
            padding-top: 20px;
            border-top: 1px solid #eee;
            color: #6c757d;
            font-size: 0.9rem;
        }
        
        .password-toggle {
            cursor: pointer;
            color: var(--secondary-color);
        }
        
        .password-toggle:hover {
            color: var(--primary-color);
        }
        
        .login-icon {
            font-size: 3rem;
            margin-bottom: 15px;
            color: rgba(255,255,255,0.9);
        }
        
        .company-logo {
            font-weight: bold;
            color: var(--primary-color);
            font-size: 1.2rem;
        }
        
        @media (max-width: 576px) {
            .login-card {
                border-radius: 10px;
            }
            
            .login-header, .login-body {
                padding: 25px;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-card">
            <!-- Header -->
            <div class="login-header">
                <div class="login-icon">
                    <i class="fas fa-user-lock"></i>
                </div>
                <h2>Connexion</h2>
                <p>Système de Gestion des Congés</p>
            </div>
            
            <!-- Body -->
            <div class="login-body">
                <!-- Messages d'erreur/succès -->
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger" role="alert">
                        <i class="fas fa-exclamation-circle"></i>
                        <div>
                            <strong>Identifiants invalides</strong>
                            <div class="small">Veuillez vérifier votre nom d'utilisateur et mot de passe</div>
                        </div>
                    </div>
                </c:if>
                
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success" role="alert">
                        <i class="fas fa-check-circle"></i>
                        <div>
                            <strong>Déconnecté avec succès</strong>
                            <div class="small">Vous avez été déconnecté de manière sécurisée</div>
                        </div>
                    </div>
                </c:if>
                
                <!-- Formulaire de connexion -->
                <form action="${pageContext.request.contextPath}/perform_login" method="post" id="loginForm">
                    <!-- Nom d'utilisateur -->
                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-user"></i> Nom d'utilisateur
                        </label>
                        <div class="input-group">
                            <input type="text" 
                                   name="username" 
                                   class="form-control" 
                                   placeholder="Entrez votre nom d'utilisateur"
                                   required
                                   autofocus>
                        </div>
                    </div>
                    
                    <!-- Mot de passe -->
                    <div class="form-group">
                        <label class="form-label">
                            <i class="fas fa-key"></i> Mot de passe
                        </label>
                        <div class="input-group">
                            <input type="password" 
                                   name="password" 
                                   id="password"
                                   class="form-control" 
                                   placeholder="Entrez votre mot de passe"
                                   required>
                            <span class="input-group-text password-toggle" id="togglePassword">
                                <i class="fas fa-eye"></i>
                            </span>
                        </div>
                        <div class="form-text text-end">
                            <a href="#" class="text-decoration-none small">Mot de passe oublié ?</a>
                        </div>
                    </div>
                    
                    <!-- Bouton de connexion -->
                    <button type="submit" class="btn btn-login">
                        <i class="fas fa-sign-in-alt me-2"></i> Se connecter
                    </button>
                    
                    <!-- Token CSRF (caché) -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                
                <!-- Informations supplémentaires -->
                <div class="footer-links">
                    <div class="small mb-2">
                        <span class="company-logo">JLRV</span> © 2025 - Tous droits réservés
                    </div>
                    <div class="small text-muted">
                        <i class="fas fa-info-circle me-1"></i>
                        Utilisez vos identifiants système
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS Bundle avec Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script>
        // Toggle visibilité mot de passe
        document.getElementById('togglePassword').addEventListener('click', function() {
            const passwordInput = document.getElementById('password');
            const icon = this.querySelector('i');
            
            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                icon.classList.remove('fa-eye');
                icon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                icon.classList.remove('fa-eye-slash');
                icon.classList.add('fa-eye');
            }
        });
        
        // Animation au chargement
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('loginForm');
            form.classList.add('loaded');
        });
        
        // Validation basique
        document.getElementById('loginForm').addEventListener('submit', function(e) {
            const username = this.querySelector('input[name="username"]');
            const password = this.querySelector('input[name="password"]');
            
            if (!username.value.trim() || !password.value.trim()) {
                e.preventDefault();
                if (!username.value.trim()) {
                    username.classList.add('is-invalid');
                }
                if (!password.value.trim()) {
                    password.classList.add('is-invalid');
                }
            }
        });
        
        // Retirer l'état d'erreur lors de la saisie
        document.querySelectorAll('input').forEach(input => {
            input.addEventListener('input', function() {
                this.classList.remove('is-invalid');
            });
        });
    </script>
</body>
</html>