
from django.contrib import admin
from django.urls import path
from django.urls.conf import include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('ml_api/', include('ml_api.urls')),
    path('recommendations/', include('recommendations.urls')),
]
