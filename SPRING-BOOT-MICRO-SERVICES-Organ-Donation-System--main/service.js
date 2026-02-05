const apiBase = "http://localhost:8000"; // API Gateway Port

// Add Donor
document.getElementById("donorForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const donor = {
    donor_name: document.getElementById("donorName").value,
    type_of_organ: document.getElementById("organType").value
  };

  const response = await fetch(`${apiBase}/donors`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(donor)
  });

  if (response.ok) {
    alert("Donor added!");
    fetchDonors();
    e.target.reset();
  } else {
    alert("Failed to add donor. Try again later.");
  }
});

// Get Donors and display in table
async function fetchDonors() {
  document.getElementById("donorTableSection").style.display = "block";

  const res = await fetch(`${apiBase}/donors`);
  const data = await res.json();

  const tableBody = document.getElementById("donorList");
  tableBody.innerHTML = "";

  data.forEach(donor => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${donor.donor_id}</td>
      <td>${donor.donor_name}</td>
      <td>${donor.type_of_organ}</td>
    `;
    tableBody.appendChild(row);
  });
}

// Toggle visibility of Donor Table
function toggleDonorTable() {
  const donorTableSection = document.getElementById("donorTableSection");
  donorTableSection.classList.toggle("hidden");
}

// Add Recipient
document.getElementById("recipientForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const recipient = {
    recipient_name: document.getElementById("recipientName").value,
    recipient_age: document.getElementById("recipientAge").value,
    donorId: document.getElementById("donorId").value
  };

  const response = await fetch(`${apiBase}/recipients/placeRecipient`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(recipient)
  });

  if (response.ok) {
    const result = await response.json();
    alert(`Recipient added successfully: RECIPIENT ID ${result.recipient_Id}`);
    fetchRecipients();
    e.target.reset();
  } else {
    alert("Not Available. Please contact admin via mail.");
  }
});

// Get Recipients and display in table
async function fetchRecipients() {
  document.getElementById("recipientTableSection").style.display = "block";

  const res = await fetch(`${apiBase}/recipients`);
  const data = await res.json();

  const tableBody = document.getElementById("recipientList");
  tableBody.innerHTML = "";

  data.forEach(recipient => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${recipient.recipientId}</td>
      <td>${recipient.recipient_name}</td>
      <td>${recipient.recipient_age}</td>
      <td>${recipient.donorId}</td>
    `;
    tableBody.appendChild(row);
  });
}

// Toggle visibility for Donor Table
function toggleDonorTable() {
    const donorSection = document.getElementById("donorTableSection");
    const btn = document.getElementById("toggleDonorBtn");
    
    if (donorSection.classList.contains("hidden")) {
      donorSection.classList.remove("hidden");
      btn.textContent = "Hide Donor List";
    } else {
      donorSection.classList.add("hidden");
      btn.textContent = "Show Donor List";
    }
  }
  
  // Toggle visibility for Recipient Table
  function toggleRecipientTable() {
    const recipientSection = document.getElementById("recipientTableSection");
    const btn = document.getElementById("toggleRecipientBtn");
    
    if (recipientSection.classList.contains("hidden")) {
      recipientSection.classList.remove("hidden");
      btn.textContent = "Hide Recipient List";
    } else {
      recipientSection.classList.add("hidden");
      btn.textContent = "Show Recipient List";
    }
  }
