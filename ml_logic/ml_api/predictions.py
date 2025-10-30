from tensorflow.keras.models import load_model # tensorflow is  used to train our model
import numpy as np # for numerical operations
from PIL import Image # for image processing

# Load your trained model (only once)
cnn_model = load_model("Models/Models/cnn_model.h5")

def predict_image(image_file):
    # Convert and resize image
    img = Image.open(image_file).resize((128, 128)) # resized to match model input size, input meaning what trained our model
    img_array = np.array(img) / 255.0 # convert to pillow image to array and normalize
    img_array = np.expand_dims(img_array, axis=0) # add batch dimension

    # Predict authenticity
    prediction = cnn_model.predict(img_array)
    result = float(prediction[0][0])# get the prediction score
    return "Authentic" if result > 0.5 else "AI-generated"
