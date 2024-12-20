// app.js

function updateOwned(id, action) {
    let ownedElement = document.getElementById("owned-" + id);
    let currentOwned = parseInt(ownedElement.textContent);
    let newOwned = (action === 'increase') ? currentOwned + 1 : currentOwned - 1;

    // Construct the URL dynamically
    let url = "/updateOwned/" + id + "/" + newOwned;

    // Send the request
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
            // Check for redirection
            if (response.redirected) {
                window.location.href = response.url; // Redirect the page
            } else {
                throw new Error('Error updating the record');
            }
        })
        .catch(error => {
            console.error('Error updating the record', error);
            alert("Error updating the record");
        });
}
