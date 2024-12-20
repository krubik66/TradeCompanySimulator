function updateOwned(recordId, action) {
    // Get the current owned value from the DOM
    const ownedCell = document.getElementById('owned-' + recordId);
    let currentOwned = parseInt(ownedCell.textContent);

    console.log(parseInt(document.getElementById('quantity-' + recordId).value));

    // Determine if we're increasing or decreasing the owned value
    if (action === 'increase') {
        currentOwned = currentOwned + parseInt(document.getElementById('quantity-' + recordId).value);
    } else if (action === 'decrease' && currentOwned > 0) {
        currentOwned = currentOwned - parseInt(document.getElementById('quantity-' + recordId).value);
    }

    // Send the updated owned value to the backend using fetch
    fetch(`/updateOwned/${recordId}/${currentOwned}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            owned: currentOwned
        })
    })
//    .then(response => {
//        if (response.ok) {
//            // Only update the DOM if the server responds successfully
//            console.log('response is ' + response.body);
//            for
//            console.log('response is ' + response.body);
//            ownedCell.textContent = currentOwned;
//        } else {
//            // Handle error if needed
//            alert('Error updating the record');
//        }
//    })
//    .catch(error => {
//        console.error('Error:', error);
//        alert('Error updating the record');
//    });
    .then(response => response.json())  // Parse JSON response from backend
    .then(data => {
        // Update the DOM with the new owned value from the response
        if (data) {
            for (const key in data) {
                if (data.hasOwnProperty(key)) {
                    console.log(key + ': ' + data[key]);
                    document.getElementById(key + '-' + data.id).textContent = data[key];
                }
            }
            if (ownedCell.textContent != data.totalStock) {
                ownedCell.textContent = data.owned;  // Update the displayed owned value
            } else {
                alert('You already have every single one');
            }
        } else {
            alert('Error updating the record');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error updating the record');
    });
}