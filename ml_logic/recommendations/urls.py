from .views import recommend_view
from django.urls import path, include
urlpatterns = [
    path('recommend/', recommend_view, name='recommend'),]