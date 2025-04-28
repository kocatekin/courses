---
marp: true
theme: beam
paginate: true
header: SAD - Kanban
footer: spring 2025

---

<!-- _class: title -->
# Kanban 

Istanbul Arel University
Spring 2025

---

# What is Kanban?

- **Kanban** means "**signboard**" or "**visual signal**" in Japanese.
- A method to **visualize work**, **limit work-in-progress (WIP)**, and **optimize flow**.
- Originally developed in **Toyota factories** for just-in-time manufacturing.

---

# Core Principles of Kanban

1. **Visualize** the work.
2. **Limit work-in-progress**.
3. **Manage flow**.
4. **Make process policies explicit**.
5. **Implement feedback loops**.
6. **Improve collaboratively**, evolve experimentally.

---

# Kanban Board Explained

A Kanban board has **columns** that represent the workflow:

| Column | Meaning             |
|:------|:--------------------|
| To Do  | Tasks not started yet |
| In Progress | Tasks currently being worked on |
| Done   | Completed tasks |

Boards can have **more columns** depending on project complexity (e.g., Review, Testing, Deployment).

---

# Work In Progress (WIP) Limits

- **WIP Limits** restrict how many tasks can be in each column at once.
- Forces focus on **finishing work** rather than **starting new work**.
- Example: 
   - "In Progress" column may have a limit of 3 items.

---

# Why Use WIP Limits?

- Reduces **task switching**.
- Highlights **bottlenecks**.
- Improves **predictability**.
- Leads to **faster delivery**.

---

# How to Set WIP Limits?

- Start by **observing current workflow**.
- Set a **reasonable limit** per column (e.g., "No more than 3 tasks in 'In Progress'").
- Adjust based on **team size** and **task complexity**.
- **Monitor** and **adapt** limits over time.

---

# Visual Example of WIP Limits

| Column            | WIP Limit |
|:------------------|:---------:|
| To Do             |    -      |
| In Progress       |     3     |
| Ready for Review  |     2     |
| Done              |    -      |

> If the "In Progress" column is full, team members must **finish** a task before **starting** a new one.

---

# Kanban vs Scrum

| Feature | Kanban | Scrum |
|:--------|:-------|:------|
| Framework | Flow-based | Iteration-based (Sprints) |
| Roles | No required roles | Scrum Master, Product Owner, Development Team |
| Changes | Continuous | Only between sprints |
| Planning | On-demand | Sprint planning required |

---

# Benefits of Kanban

- **Flexible and lightweight**.
- **Easy to adopt** — no big changes required.
- **Improves transparency** and communication.
- **Focus on continuous delivery**.
- Great for **maintenance**, **support**, and **operational teams**.

---

# Physical Kanban Boards

- A **whiteboard** or **wall** divided into columns.
   - **Sticky notes**, **index cards**, or **magnets** represent tasks.
   - **Tangible and visible** to everyone physically present.
   - Encourages **team collaboration** and **daily interaction**.
   - Example tools: Whiteboards, bulletin boards, corkboards.

---

# Digital Kanban Boards

- **Software-based**; accessible remotely.
   - Features like **notifications**, **integrations**, and **analytics**.
   - Ideal for **distributed teams**.
   - Easier to **scale**, **archive**, and **automate**.
   - Example tools: Trello, Jira, Asana, ClickUp.

---

# What Information Should Be on a Card?

- **Task Title**: Clear and short description.
- **Owner**: Who is responsible for it?
- **Deadline** (optional): Due dates if applicable.
- **Priority**: High, Medium, Low.
- **Additional Notes**: Any necessary detail or checklist.
- **Tags or Labels**: Categorization (e.g., Bug, Feature, Research).

---

# Example of a Kanban Card

```
-------------------------------------------------
| Title:  Fix login bug                         |
| Owner:  Alice                                 |
| Priority: High                                |
| Due:    2025-05-01                            |
| Notes:  Happens only on mobile browsers.      |
| Tags:   Bug, Mobile                           |
-------------------------------------------------
```

---

# Typical Kanban Columns

## Basic Columns

- **To Do**  
  - Tasks that are approved and ready to be worked on.

- **In Progress**  
  - Tasks actively being worked on right now.

- **Done**  
  - Tasks that are completed and verified.

---

# Extended Columns (Optional)

- **Backlog**  
  - Ideas or unapproved tasks waiting for prioritization.

- **Ready for Review**  
  - Tasks completed but awaiting peer review or QA.

- **Blocked**  
  - Tasks that cannot proceed due to external factors.

- **Ready for Deployment**  
  - Fully done but pending release to production.

---



# Real-Life Example

## IT Helpdesk

- To Do: New ticket received.
- In Progress: Technician is working on the ticket.
- Done: Ticket resolved and closed.

**WIP Limit**: No more than 5 tickets being worked on simultaneously.

---

# Closing Advice

- Start **simple**; evolve your board.
- Focus on **finishing work**, not just starting it.
- Continuously **inspect and adapt** your workflow.
- Visualize everything — even **waiting times** and **handoffs**!

---

# Kanban as a philosophy

- Life is more sustainable when we focus on *movement*, not *multitasking*
- Limit your WIP
   - Too many open tasks: _anxiety_, _stress_
   - Limiting the focus creates **clarity**.
- Kanban makes progress **visible**
   - Write down your tasks
- CI (Continuous improvement)
   - Kanban is not just about finishing tasks, also about **observing** and **improving** the way we work.
   - We can reflect weekly and see if there is room for improvement
