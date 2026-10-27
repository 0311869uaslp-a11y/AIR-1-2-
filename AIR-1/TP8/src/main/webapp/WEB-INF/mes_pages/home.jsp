<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord - Gestion Congés</title>
    
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <!-- Chart.js pour les statistiques -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    <!-- Custom CSS -->
    <style>
        :root {
            --primary-color: #2c3e50;
            --secondary-color: #3498db;
            --accent-color: #e74c3c;
            --success-color: #27ae60;
            --warning-color: #f39c12;
            --light-bg: #f8f9fa;
            --sidebar-width: 250px;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f7fa;
            color: #333;
        }
        
        /* Sidebar */
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            width: var(--sidebar-width);
            height: 100vh;
            background: linear-gradient(180deg, var(--primary-color) 0%, #1a252f 100%);
            color: white;
            padding: 0;
            box-shadow: 3px 0 10px rgba(0,0,0,0.1);
            z-index: 1000;
        }
        
        .sidebar-brand {
            padding: 25px 20px;
            text-align: center;
            border-bottom: 1px solid rgba(255,255,255,0.1);
        }
        
        .sidebar-brand h3 {
            margin: 0;
            font-weight: 700;
            color: white;
        }
        
        .sidebar-brand .logo-icon {
            font-size: 2rem;
            margin-bottom: 10px;
            color: var(--secondary-color);
        }
        
        .sidebar-menu {
            padding: 20px 0;
        }
        
        .sidebar-item {
            padding: 0;
        }
        
        .sidebar-link {
            display: flex;
            align-items: center;
            padding: 15px 25px;
            color: rgba(255,255,255,0.8);
            text-decoration: none;
            transition: all 0.3s;
            border-left: 4px solid transparent;
        }
        
        .sidebar-link:hover {
            background-color: rgba(255,255,255,0.1);
            color: white;
            border-left: 4px solid var(--secondary-color);
        }
        
        .sidebar-link.active {
            background-color: rgba(52, 152, 219, 0.2);
            color: white;
            border-left: 4px solid var(--secondary-color);
        }
        
        .sidebar-link i {
            width: 25px;
            font-size: 1.2rem;
            margin-right: 12px;
        }
        
        /* Main Content */
        .main-content {
            margin-left: var(--sidebar-width);
            padding: 20px;
            min-height: 100vh;
        }
        
        /* Header */
        .top-bar {
            background: white;
            border-radius: 10px;
            padding: 15px 25px;
            margin-bottom: 30px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        .user-info {
            display: flex;
            align-items: center;
            gap: 15px;
        }
        
        .user-avatar {
            width: 45px;
            height: 45px;
            background: linear-gradient(135deg, var(--secondary-color), var(--primary-color));
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
            font-size: 1.2rem;
        }
        
        .user-details h4 {
            margin: 0;
            font-weight: 600;
        }
        
        .user-details .user-role {
            font-size: 0.85rem;
            color: #6c757d;
        }
        
        .logout-btn {
            background: linear-gradient(to right, #e74c3c, #c0392b);
            color: white;
            border: none;
            border-radius: 6px;
            padding: 8px 20px;
            font-weight: 500;
            transition: all 0.3s;
            display: flex;
            align-items: center;
            gap: 8px;
        }
        
        .logout-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(231, 76, 60, 0.2);
        }
        
        /* Welcome Card */
        .welcome-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border-radius: 15px;
            padding: 30px;
            margin-bottom: 30px;
            box-shadow: 0 10px 30px rgba(102, 126, 234, 0.3);
        }
        
        .welcome-icon {
            font-size: 3.5rem;
            opacity: 0.9;
            margin-bottom: 15px;
        }
        
        .welcome-text h2 {
            font-weight: 700;
            margin-bottom: 10px;
        }
        
        .welcome-text p {
            opacity: 0.9;
            margin-bottom: 0;
        }
        
        /* Stats Cards */
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        
        .stat-card {
            background: white;
            border-radius: 10px;
            padding: 25px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            transition: transform 0.3s;
        }
        
        .stat-card:hover {
            transform: translateY(-5px);
        }
        
        .stat-icon {
            width: 60px;
            height: 60px;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 1.8rem;
            margin-bottom: 15px;
        }
        
        .stat-icon.pending {
            background-color: rgba(243, 156, 18, 0.1);
            color: var(--warning-color);
        }
        
        .stat-icon.approved {
            background-color: rgba(39, 174, 96, 0.1);
            color: var(--success-color);
        }
        
        .stat-icon.rejected {
            background-color: rgba(231, 76, 60, 0.1);
            color: var(--accent-color);
        }
        
        .stat-icon.total {
            background-color: rgba(52, 152, 219, 0.1);
            color: var(--secondary-color);
        }
        
        .stat-value {
            font-size: 2rem;
            font-weight: 700;
            margin-bottom: 5px;
        }
        
        .stat-label {
            color: #6c757d;
            font-size: 0.9rem;
        }
        
        /* Quick Actions */
        .quick-actions {
            background: white;
            border-radius: 10px;
            padding: 25px;
            margin-bottom: 30px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
        }
        
        .section-title {
            font-weight: 600;
            margin-bottom: 20px;
            color: var(--primary-color);
            padding-bottom: 10px;
            border-bottom: 2px solid var(--light-bg);
        }
        
        .action-buttons {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
        }
        
        .action-btn {
            background: white;
            border: 2px solid var(--light-bg);
            border-radius: 8px;
            padding: 15px 20px;
            min-width: 180px;
            text-align: center;
            text-decoration: none;
            color: var(--primary-color);
            transition: all 0.3s;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 10px;
        }
        
        .action-btn:hover {
            border-color: var(--secondary-color);
            background-color: rgba(52, 152, 219, 0.05);
            transform: translateY(-2px);
        }
        
        .action-btn i {
            font-size: 1.8rem;
            color: var(--secondary-color);
        }
        
        /* Direction Alert (only for ROLE_DIRECTION) */
        .direction-alert {
            background: linear-gradient(to right, #27ae60, #2ecc71);
            color: white;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 30px;
            display: flex;
            align-items: center;
            gap: 20px;
            animation: slideIn 0.5s ease-out;
        }
        
        @keyframes slideIn {
            from { opacity: 0; transform: translateX(-20px); }
            to { opacity: 1; transform: translateX(0); }
        }
        
        .direction-icon {
            font-size: 2.5rem;
        }
        
        .direction-content h4 {
            margin: 0 0 5px 0;
            font-weight: 600;
        }
        
        .direction-content p {
            margin: 0;
            opacity: 0.9;
        }
        
        /* Responsive */
        @media (max-width: 992px) {
            .sidebar {
                width: 70px;
            }
            
            .sidebar-brand h3, .sidebar-link span {
                display: none;
            }
            
            .sidebar-link {
                justify-content: center;
                padding: 20px 0;
            }
            
            .sidebar-link i {
                margin-right: 0;
                font-size: 1.4rem;
            }
            
            .main-content {
                margin-left: 70px;
            }
        }
        
        @media (max-width: 768px) {
            .stats-grid {
                grid-template-columns: 1fr;
            }
            
            .action-buttons {
                justify-content: center;
            }
            
            .action-btn {
                min-width: 150px;
            }
        }
    </style>
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-brand">
            <div class="logo-icon">
                <i class="fas fa-calendar-alt"></i>
            </div>
            <h3>Ecoalis</h3>
            <small class="text-muted">Gestion Congés</small>
        </div>
        
        <div class="sidebar-menu">
            <div class="sidebar-item">
                <a href="${pageContext.request.contextPath}/home" class="sidebar-link active">
                    <i class="fas fa-home"></i>
                    <span>Tableau de bord</span>
                </a>
            </div>
            
            <div class="sidebar-item">
                <a href="${pageContext.request.contextPath}/ddc/listerDdc" class="sidebar-link">
                    <i class="fas fa-list"></i>
                    <span>Mes demandes</span>
                </a>
            </div>
            
            <div class="sidebar-item">
                <a href="${pageContext.request.contextPath}/creerDdc" class="sidebar-link">
                    <i class="fas fa-plus-circle"></i>
                    <span>Nouvelle demande</span>
                </a>
            </div>
            
            <sec:authorize access="hasRole('ROLE_DIRECTION')">
                <div class="sidebar-item">
                    <a href="${pageContext.request.contextPath}/ddc/direction" class="sidebar-link">
                        <i class="fas fa-user-tie"></i>
                        <span>Espace Direction</span>
                    </a>
                </div>
                
                <div class="sidebar-item">
                    <a href="${pageContext.request.contextPath}/admin" class="sidebar-link">
                        <i class="fas fa-cog"></i>
                        <span>Administration</span>
                    </a>
                </div>
            </sec:authorize>
            
            <div class="sidebar-item">
                <a href="${pageContext.request.contextPath}/profile" class="sidebar-link">
                    <i class="fas fa-user"></i>
                    <span>Mon profil</span>
                </a>
            </div>
        </div>
    </div>
    
    <!-- Main Content -->
    <div class="main-content">
        <!-- Top Bar -->
        <div class="top-bar">
            <div class="user-info">
                <div class="user-avatar">
                    <sec:authentication property="principal.username" var="username"/>
                    <c:set var="initial" value="${fn:substring(username, 0, 1)}" />
                    ${fn:toUpperCase(initial)}
                </div>
                <div class="user-details">
                    <h4>Bonjour, <sec:authentication property="principal.username"/></h4>
                    <div class="user-role">
                        <sec:authorize access="hasRole('ROLE_DIRECTION')">
                            <i class="fas fa-user-tie me-1"></i> Direction
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <i class="fas fa-user me-1"></i> Collaborateur
                        </sec:authorize>
                    </div>
                </div>
            </div>
            
            <form action="${pageContext.request.contextPath}/logout" method="post" class="mb-0">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="logout-btn">
                    <i class="fas fa-sign-out-alt"></i>
                    Déconnexion
                </button>
            </form>
        </div>
        
        <!-- Welcome Card -->
        <div class="welcome-card">
            <div class="d-flex align-items-center">
                <div class="welcome-icon me-4">
                    <i class="fas fa-hand-sparkles"></i>
                </div>
                <div class="welcome-text">
                    <h2>Bienvenue sur votre tableau de bord</h2>
                    <p>Gérez facilement vos demandes de congés et consultez vos statistiques en temps réel.</p>
                </div>
            </div>
        </div>
        
        <!-- Direction Alert (only for ROLE_DIRECTION) -->
        <sec:authorize access="hasRole('ROLE_DIRECTION')">
            <div class="direction-alert">
                <div class="direction-icon">
                    <i class="fas fa-star"></i>
                </div>
                <div class="direction-content">
                    <h4>Accès Direction Activé</h4>
                    <p>Vous disposez des privilèges d'administration. Vous pouvez accéder à l'espace direction et valider les demandes de congés.</p>
                </div>
            </div>
        </sec:authorize>
        
        <!-- Statistics Cards -->
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-icon pending">
                    <i class="fas fa-clock"></i>
                </div>
                <div class="stat-value">3</div>
                <div class="stat-label">En attente</div>
                <div class="small text-muted">Demandes à traiter</div>
            </div>
            
            <div class="stat-card">
                <div class="stat-icon approved">
                    <i class="fas fa-check-circle"></i>
                </div>
                <div class="stat-value">12</div>
                <div class="stat-label">Approuvées</div>
                <div class="small text-muted">Cette année</div>
            </div>
            
            <div class="stat-card">
                <div class="stat-icon rejected">
                    <i class="fas fa-times-circle"></i>
                </div>
                <div class="stat-value">2</div>
                <div class="stat-label">Rejetées</div>
                <div class="small text-muted">Demandes refusées</div>
            </div>
            
            <div class="stat-card">
                <div class="stat-icon total">
                    <i class="fas fa-calendar-alt"></i>
                </div>
                <div class="stat-value">25</div>
                <div class="stat-label">Jours restants</div>
                <div class="small text-muted">Solde de congés</div>
            </div>
        </div>
        
        <!-- Quick Actions -->
        <div class="quick-actions">
            <h4 class="section-title">
                <i class="fas fa-bolt me-2"></i>Actions rapides
            </h4>
            <div class="action-buttons">
                <a href="${pageContext.request.contextPath}/creerDdc" class="action-btn">
                    <i class="fas fa-plus-circle"></i>
                    <span>Nouvelle demande</span>
                </a>
                
                <a href="${pageContext.request.contextPath}/ddc/listerDdc" class="action-btn">
                    <i class="fas fa-list"></i>
                    <span>Voir mes demandes</span>
                </a>
                
                <a href="${pageContext.request.contextPath}/calendar" class="action-btn">
                    <i class="fas fa-calendar"></i>
                    <span>Calendrier</span>
                </a>
                
                <sec:authorize access="hasRole('ROLE_DIRECTION')">
                    <a href="${pageContext.request.contextPath}/ddc/direction" class="action-btn">
                        <i class="fas fa-user-tie"></i>
                        <span>Espace direction</span>
                    </a>
                </sec:authorize>
                
                <a href="${pageContext.request.contextPath}/profile" class="action-btn">
                    <i class="fas fa-user-cog"></i>
                    <span>Mon profil</span>
                </a>
            </div>
        </div>
        
        <!-- Recent Activity -->
        <div class="quick-actions">
            <h4 class="section-title">
                <i class="fas fa-history me-2"></i>Activité récente
            </h4>
            <div class="list-group">
                <div class="list-group-item border-0 py-3">
                    <div class="d-flex w-100 justify-content-between">
                        <div>
                            <i class="fas fa-check-circle text-success me-2"></i>
                            <strong>Demande #2456</strong> approuvée
                        </div>
                        <small class="text-muted">Il y a 2 jours</small>
                    </div>
                </div>
                <div class="list-group-item border-0 py-3">
                    <div class="d-flex w-100 justify-content-between">
                        <div>
                            <i class="fas fa-paper-plane text-primary me-2"></i>
                            <strong>Demande #2457</strong> soumise
                        </div>
                        <small class="text-muted">Il y a 3 jours</small>
                    </div>
                </div>
                <div class="list-group-item border-0 py-3">
                    <div class="d-flex w-100 justify-content-between">
                        <div>
                            <i class="fas fa-user-check text-info me-2"></i>
                            Connexion réussie
                        </div>
                        <small class="text-muted">Aujourd'hui, 10:24</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- JSTL Functions (needed for string manipulation) -->
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script>
        // Initiales pour l'avatar
        document.addEventListener('DOMContentLoaded', function() {
            // Mettre à jour la date dans le dashboard
            const now = new Date();
            const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
            // document.getElementById('currentDate').textContent = now.toLocaleDateString('fr-FR', options);
            
            // Animation des cartes statistiques
            const statCards = document.querySelectorAll('.stat-card');
            statCards.forEach((card, index) => {
                card.style.animationDelay = `${index * 0.1}s`;
            });
            
            // Sidebar active link
            const currentPath = window.location.pathname;
            const sidebarLinks = document.querySelectorAll('.sidebar-link');
            
            sidebarLinks.forEach(link => {
                if (link.getAttribute('href') === currentPath) {
                    link.classList.add('active');
                } else {
                    link.classList.remove('active');
                }
            });
        });
        
        // Chart pour les statistiques (exemple)
        function initStatsChart() {
            const ctx = document.getElementById('statsChart');
            if (ctx) {
                new Chart(ctx, {
                    type: 'doughnut',
                    data: {
                        labels: ['En attente', 'Approuvées', 'Rejetées'],
                        datasets: [{
                            data: [3, 12, 2],
                            backgroundColor: [
                                'rgba(243, 156, 18, 0.8)',
                                'rgba(39, 174, 96, 0.8)',
                                'rgba(231, 76, 60, 0.8)'
                            ],
                            borderWidth: 0
                        }]
                    },
                    options: {
                        responsive: true,
                        plugins: {
                            legend: {
                                position: 'bottom',
                            }
                        }
                    }
                });
            }
        }
        
        // Initialiser le chart quand la page est prête
        document.addEventListener('DOMContentLoaded', initStatsChart);
    </script>
</body>
</html>