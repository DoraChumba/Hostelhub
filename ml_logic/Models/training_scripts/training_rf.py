import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import joblib
import os

# Load dataset
data_path = os.path.join(os.path.dirname(__file__), '../../data/property_data.csv')
df = pd.read_csv(data_path)

# Split features and target
X = df[['rent', 'location','amenities']]
y = df['recommendation']

# Split into training and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train model
rf_model = RandomForestClassifier(n_estimators=100)
rf_model.fit(X_train, y_train)

# Evaluate
y_pred = rf_model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"✅ RF Model Accuracy: {accuracy:.2f}")

# Save model
model_save_path = os.path.join(os.path.dirname(__file__), '../random_forest.pkl')
os.makedirs(os.path.dirname(model_save_path), exist_ok=True)
joblib.dump(rf_model, model_save_path)

print("🎯 Random Forest Model saved at:", model_save_path)
