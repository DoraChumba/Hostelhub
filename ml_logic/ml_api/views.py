from rest_framework.decorators import api_view
from rest_framework.response import Response
from .predictions import predict_image

@api_view(['POST'])
def predict_view(request):
    if 'image' not in request.FILES:
        return Response({"error": "No image uploaded"}, status=400)

    image_file = request.FILES['image']
    result = predict_image(image_file)

    return Response({"prediction": result})


# Create your views here.
