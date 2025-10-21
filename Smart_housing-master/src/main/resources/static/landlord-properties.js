// landlord-properties.js

async function fetchProperties(landlordId) {
    try {
        const res = await fetch(`/api/landlord/properties`, {
            headers: { 'X-Landlord-Id': landlordId }
        });
        const properties = await res.json();
        renderProperties(properties);
    } catch (err) {
        console.error('Failed to load properties', err);
        alert('Error loading properties');
    }
}

function renderProperties(properties) {
    const tbody = document.getElementById('propertiesBody');
    tbody.innerHTML = '';
    properties.forEach(p => {
        const row = tbody.insertRow();
        row.innerHTML = `
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.location}</td>
            <td>${p.type}</td>
            <td>KES ${p.price}</td>
            <td>${p.status || 'VACANT'}</td>
            <td>
                <button onclick="editProperty(${p.id})">Edit</button>
                <button onclick="deleteProperty(${p.id}, ${landlordId})" style="background:red;color:white;">Delete</button>
            </td>
        `;
    });
}

function openCreateModal() {
    document.getElementById('modalTitle').textContent = 'Add New Property';
    document.getElementById('propertyForm').reset();
    document.getElementById('propertyId').value = '';
    document.getElementById('propertyModal').style.display = 'block';
}

function closeModal() {
    document.getElementById('propertyModal').style.display = 'none';
}

document.getElementById('propertyForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const landlordId = window.LANDLORD_ID || 1;

    const property = {
        name: document.getElementById('name').value,
        location: document.getElementById('location').value,
        type: document.getElementById('type').value,
        maxOccupancy: parseInt(document.getElementById('maxOccupancy').value),
        price: parseFloat(document.getElementById('price').value),
        description: document.getElementById('description').value
    };

    const propertyId = document.getElementById('propertyId').value;

    try {
        let response;
        if (propertyId) {
            // Update
            response = await fetch(`/api/landlord/properties/${propertyId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'X-Landlord-Id': landlordId
                },
                body: JSON.stringify(property)
            });
        } else {
            // Create
            response = await fetch('/api/landlord/properties', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-Landlord-Id': landlordId
                },
                body: JSON.stringify(property)
            });
        }

        if (response.ok) {
            closeModal();
            fetchProperties(landlordId);
        } else {
            alert('Operation failed');
        }
    } catch (err) {
        console.error(err);
        alert('Network error');
    }
});

async function editProperty(id) {
    const landlordId = window.LANDLORD_ID || 1;
    try {
        const res = await fetch(`/api/landlord/properties/${id}`, {
            headers: { 'X-Landlord-Id': landlordId }
        });
        const p = await res.json();
        document.getElementById('propertyId').value = p.id;
        document.getElementById('name').value = p.name;
        document.getElementById('location').value = p.location;
        document.getElementById('type').value = p.type;
        document.getElementById('maxOccupancy').value = p.maxOccupancy;
        document.getElementById('price').value = p.price;
        document.getElementById('description').value = p.description || '';
        document.getElementById('modalTitle').textContent = 'Edit Property';
        document.getElementById('propertyModal').style.display = 'block';
    } catch (err) {
        alert('Failed to load property');
    }
}

async function deleteProperty(id, landlordId) {
    if (!confirm('Are you sure?')) return;
    try {
        const res = await fetch(`/api/landlord/properties/${id}`, {
            method: 'DELETE',
            headers: { 'X-Landlord-Id': landlordId }
        });
        if (res.ok) {
            fetchProperties(landlordId);
        } else {
            alert('Delete failed');
        }
    } catch (err) {
        alert('Error deleting property');
    }
}