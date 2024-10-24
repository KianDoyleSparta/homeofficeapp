PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git fsck --full
Checking object directories: 100% (256/256), done.
Checking objects: 100% (81/81), done.
broken link from    tree ebb64c0103da855465e1c3a8d465ac06012a3fb1
              to    blob 4fe7ca89bea5064ea91e05dfce8774660bd66716
dangling commit 19d49ba0f135f16fdbf3eb5f663d960790fa3f3f
dangling commit 5b3e06b39f88f6aac036e9809f989185a97f5ace
missing blob 4fe7ca89bea5064ea91e05dfce8774660bd66716
dangling commit bb2b9ed7ccb3f6639b2b3bbd4ffe6d9997b819cb
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git checkout --orphan temp_branch 
Switched to a new branch 'temp_branch'
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git add .
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git commit -m "Recommit files after fixing missing blobs"
[temp_branch (root-commit) cffdafa] Recommit files after fixing missing blobs
 18 files changed, 1062 insertions(+)
 create mode 100644 .gitattributes
 create mode 100644 .gitignore
 create mode 100644 HELP.md
 create mode 100644 README.md
 create mode 100644 mvnw
 create mode 100644 mvnw.cmd
 create mode 100644 pom.xml
 create mode 100644 src/main/java/com/sparta/homeoffice/HomeofficeApplication.java
 create mode 100644 src/main/java/com/sparta/homeoffice/controllers/WebController.java     
 create mode 100644 src/main/java/com/sparta/homeoffice/entities/Ticket.java
 create mode 100644 src/main/java/com/sparta/homeoffice/repositories/TicketRepository.java 
 create mode 100644 src/main/java/com/sparta/homeoffice/services/TicketService.java        
 create mode 100644 src/main/resources/templates/home.html
 create mode 100644 src/test/java/com/sparta/homeoffice/HomeofficeApplicationTests.java    
 create mode 100644 terraform.md
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git branch -D cloud
Deleted branch cloud (was 2add947).
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git branch -m cloud
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> git push -f origin cloud
Enumerating objects: 37, done.
Counting objects: 100% (37/37), done.
Delta compression using up to 2 threads
Compressing objects: 100% (21/21), done.
Writing objects: 100% (37/37), 13.96 KiB | 1.99 MiB/s, done.
Total 37 (delta 0), reused 19 (delta 0), pack-reused 0
To https://github.com/KianDoyleSparta/homeofficeapp.git
 + 394c30c...cffdafa cloud -> cloud (forced update)
PS C:\Users\James_Cole\Documents\Projects\homeofficeapp> 