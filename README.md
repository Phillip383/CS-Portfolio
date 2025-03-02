# CS-Portfolio

# CS-210

- **Summarize the project and what problem it was solving.**
  - The project lets a user manage items sold; it's primarily directed for grocery item use, but could be used for any number of inventory types. The user has multiple options they can choose from: insert new items, remove items, maybe because they were returned or entered by mistake. The program also has a search feature to retrieve the amount sold for a specific isolated item, or the user can choose to display all of the items sold in a list with corresponding frequency values or display a histogram.

- **What did you do particularly well?**
    - I think I handled user experience very well. With text output and input formatted in a way that would be easy for the user to read. I also believe that I maintained const correctness through out the program. 
  
- **Where could you enhance your code? How would these improvements make your code more efficient, secure, and so on?**
    - I would redesign the way data is originally stored and opt to the way the back up file works. I'd use the file stream to pull the lines from the file
      and then use a string stream to pull the line from the file apart and store name and number of items sold in a map. My insert and remove functions could
      default to adding only one item unless the user specifies a quantity in their input string. I believe I did a good job with input exception handling, except in the insert and remove functions, but my thought process only allowing integer value's in the input is maybe the item name includes integer values. I wanted the program to be flexible.

- **Which pieces of the code did you find most challenging to write, and how did you overcome this? What tools or resources are you adding to your support network?**
    - Well, a little ashamed of it, but the only time i really struggled was when I refactored the EMenuSelection Enum to its own file. I forgot the #pragma once and kept getting a redefinition error, it took me at least an hour to realize what i done. I relied on tools and wizards to create classes and all that boilerplate is generated for you, but i made that file myself, and my muscle memory wasn't trained to include a #ifndef or #pragma once preprocessor directive.

- **What skills from this project will be particularly transferable to other projects or course work?**
    - well as mentioned above, I'll defiantly understand a multiple definition error when i see it again, but also working with files and overloading input output stream operators will be a valuable skill moving forward. Overloading the stream insertion operator to read into my enum made my code feel more manageable, regardless it was a small program and only got input for that specific type once, but who knows what the future holds for during the program's development and maintained life cycle. I also implemented it in such a way that even when features/options are added, and the comments are adhered too; the overloaded operator will never have to be touched for the EMenuSelection type.
  
- **How did you make this program maintainable, readable, and adaptable?**
    - By using multiple classes with their own responsibility in the program and using reasonable abstraction. The main function is simple with self documenting code. Three function call's one to print the menu and one to perform the operation selected. The code base is documented very well with doxygen comments, if a future developer wanted to add a new operation all they would need to do is create the function in the operations class, add to the switch statement in PerformOperation, add the operation to EMenuSelection and add the option to the list in DisplayMenu. I overloaded the insertion operator in such a way that the code will never have to be updated there, and I wanted to find a way to reduce the amount of changes required for adding new features. I had a few ideas, but all those ideas was around the same amount of changes, but with added code complexity.

# CS-250


**How do I interpret user needs and implement them into a program? How does creating “user stories” help with this?**

- How I would approach this is by conducting interviews, surveys and end user testing such as beta access. Welcoming and being open to any feedback the stakeholders, product owner, or end users might have. User stories are a great way to structure a feature or requirement where every one involved can understand it, so it doesn't take a cs degree and knowing how to read UML diagrams or other technical implementation information. A User story can contain priority information in the form of story points for example, this can help prioritize work in a manner that suits the value delivered in a order that's appropriate for the customer.

**How do I approach developing programs? What Agile processes do I hope to incorporate into my future development work?**

- Breaking down larger problems into smaller steps is a strong way to tackle problems, so I will definitely utilize that moving forward. 
- Testing early and often is something that helps with the development cycle and saves a lot of time by reducing potential rewrites and ensuring that the implementation is meeting the requirement. 
- Staying open to feedback is the way we grow. We're human and are going to make mistakes, or misinterpret something at some point, or maybe not quite understand the problem. Asking for feedback and clarification of requirements are imperative in most cases to ensure your work is meeting expectations.
- CI/CD is definitely something I want to learn more about, and have recently started boot.dev and linkedin courses to help me get there faster. 
- I prefer scrum but see the benefit of kanban. Scrum is better suited to ensure that the team is on the same page with implementation of features with higher levels of communication. 

**What does it mean to be a good team member in software development?**

- To be apart of a team means to communicate with them about what you have got done or may need help with. Staying self-organizing and on task to get your work done, and being open to giving feedback and more importantly accepting any feedback you received, and working with your team to succeed in completing the shared goals, and fostering a growth mindset by always being open to learning new ideas and processes, as well as new technologies. As Khadgar would say "Knowledge is power."


