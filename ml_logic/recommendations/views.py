from rest_framework.decorators import api_view
from rest_framework.response import Response
from .recommend import recommend

@api_view(['POST'])
def recommend_view(request):
    features = request.data.get('features')
    if not features:
        return Response({"error": "Missing features"}, status=400)

    result = recommend(features)
    return Response({"recommendation": result})


# Create your views here.
