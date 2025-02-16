# Spring Boot Project: Video Game Store

## Project Overview
We are building a Spring Boot application for a video game store. The application will include functionalities for customers and admins/employees to manage the store, inventory, and orders. Below is the plan for collaboration, database structure, and GitHub workflow.

---

## Sitemap and Additional Pages

### Sitemap
The initial sitemap includes pages for:
- Home
- Products
- Cart
- Checkout
- Orders

### Additional Admin/Employee Page
An additional page will be created for admins/employees to manage:
- Store inventory
- Orders

---

## Database Structure
Below are the proposed database tables:

1. **User Table**
   - Stores both employee and customer user information.

2. **Roles Table**
   - Defines role-based permissions (e.g., Admin, Employee, Customer).

3. **UserRole Table**
   - Tracks which users have which roles.
   - Example columns: ID, UserId, RoleId

4. **Auth Table**
   - Stores passwords (hashed for security).
   - May not be needed if third-party authentication is used.

5. **ActiveOrders Table**
   - Tracks orders that are submitted but not yet fulfilled.
   - Includes statuses like "Processing" and "Shipped."

6. **OrdersLog Table**
   - Stores completed orders.

7. **Cart Table**
   - Saves a user's cart for returning and completing purchases later.

8. **Inventory Table**
   - Stores product information such as stock status and price.

9. **InventoryAuditLog Table**
   - Tracks manual updates to the inventory by employees (optional).

---

## Collaboration Using GitHub

### **Branching Strategy**
- Use a simple branching strategy to avoid conflicts.
- Each feature or bug fix will be developed in a separate branch.
- Branch naming convention: `[type]/[feature-name]` (e.g., `feature/login-page`).

### **Pull Requests (PRs)**
- All changes will be reviewed via PRs to:
  - Avoid code conflicts.
  - Double-check each other's work.

### **GitHub Issues**
- Use GitHub Issues to create and assign tasks.
- Follow the **User Story format**:
  - "As a [persona], I [want to], [so that]."
  - Example: "As an online shopper, I want to sort products so that I can find the best deals."
- This format helps clarify the user-focused problem being solved.

**For Reference:** https://www.atlassian.com/agile/project-management/user-stories

---

## Steps for Working with GitHub

### Cloning the Repository
To clone the repository:
```bash
git clone https://github.com/Andrew-Forster/sb-store
```

### Creating a New Branch
To create and switch to a new branch:
```bash
git checkout -b [branch-name]
```

### Making Changes
1. Make your changes locally.
2. Stage the changes:
   ```bash
   git add .
   ```
3. Commit the changes:
   ```bash
   git commit -m "[Your commit message]"
   ```

### Pushing Changes
To push your branch to GitHub:
```bash
git push origin [branch-name]
```

### Making a Pull Request
1. Go to the GitHub repository.
2. Open the **Pull Requests** tab.
3. Click **New Pull Request**.
4. Select your branch and submit the PR for review.

### Reviewing Pull Requests
- Review team members' PRs.
- Leave comments if necessary.
- Approve the PR when it's ready to merge.

### Merging Pull Requests
1. Once the PR is approved, merge it into the main branch.
2. Delete the branch after merging to keep the repository clean.

---

## Managing Tasks with GitHub Issues
1. Create GitHub Issues for tasks and bugs.
2. Use the **User Story format** for clarity.
3. Assign issues to team members.
4. Use labels (e.g., `feature`, `bug`, `enhancement`) to categorize tasks.

---

## Additional Notes
- **Video Game Store Features**: Follow the sitemap and database design to implement features incrementally.
- **Feedback**: Regularly provide feedback during code reviews and issue discussions.
- **Organization**: Use GitHub milestones to track project progress.

By following this plan, we can efficiently collaborate and deliver a high-quality Spring Boot application for the video game store.

