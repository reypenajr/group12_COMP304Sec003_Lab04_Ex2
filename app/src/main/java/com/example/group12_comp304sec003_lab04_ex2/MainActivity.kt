package com.example.group12_comp304sec003_lab04_ex2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.group12_comp304sec003_lab04_ex2.ui.theme.Group12_COMP304Sec003_Lab04_Ex2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Group12_COMP304Sec003_Lab04_Ex2Theme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    var shouldShowSoftwareEngineeringDetails by rememberSaveable { mutableStateOf(false) }
    var shouldShowHealthInformaticsDetails by rememberSaveable { mutableStateOf(false) }
    var shouldShowGameProgrammingDetails by rememberSaveable { mutableStateOf(false) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                onAISoftwareEngineeringClicked = {
                    shouldShowSoftwareEngineeringDetails = true
                    shouldShowOnboarding = false
                },

                onSoftwareEngineeringTechnicianClicked = {
                    shouldShowHealthInformaticsDetails = true
                    shouldShowOnboarding = false
                },
                onSoftwareEngineeringTechnologyClicked = {
                    shouldShowGameProgrammingDetails = true
                    shouldShowOnboarding = false
                },
            )
        } else {
            if (shouldShowSoftwareEngineeringDetails) {
                AISoftwareEngineeringDetails(modifier = Modifier.fillMaxSize())
            } else if (shouldShowHealthInformaticsDetails) {
                SoftwareEngTechnician(modifier = Modifier.fillMaxSize())
            } else if (shouldShowGameProgrammingDetails){
                SoftwareEngTechnology(modifier = Modifier.fillMaxSize())
            }
            else {
                Greetings()
            }
        }
    }
}




@Composable
fun OnboardingScreen(
    onAISoftwareEngineeringClicked: () -> Unit,
    onSoftwareEngineeringTechnicianClicked: () -> Unit,
    onSoftwareEngineeringTechnologyClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Select a Program")
        Button(
            modifier = Modifier.padding(vertical = 10.dp),
            onClick = { onAISoftwareEngineeringClicked() }
        ) {
            Text("Artificial Intelligence\nSoftware Engineering Technology")
        }
        Button(
            modifier = Modifier.padding(vertical = 10.dp),
            onClick = { onSoftwareEngineeringTechnicianClicked() }
        ) {
            Text("Software Engineering Technician")
        }
        Button(
            modifier = Modifier.padding(vertical = 10.dp),
            onClick = onSoftwareEngineeringTechnologyClicked
        ) {
            Text("Software Engineering Technology")
        }
    }
}

@Composable
private fun AISoftwareEngineeringDetails(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = listOf("COMP-214",
            "COMP-216",
            "COMP-247",
            "COMP-254",
            "COMP-311",
            "ENGL-253")) { name ->
            Greeting(name = name)
        }
    }
}
@Composable
private fun SoftwareEngTechnician(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = listOf("CNET-307",
            "COMP-212",
            "COMP-231",
            "COMP-311",
            "ENGL-318",
            "EMPS-101",
            "GNED")) { name ->
            Greeting(name = name)
        }
    }
}
@Composable
private fun SoftwareEngTechnology(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = listOf("COMP-212",
            "COMP-216",
            "COMP-254",
            "COMP-304",
            "COMP-311",
            "MATH-210")) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf(
        "Programming Development",
        "Software Engineering",
        "AI Robotics"
    )
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    val contentText = when (name) {
        "COMP-212" -> "Programming 3\nThe goal of this course is to enable students, already proficient in OOP, to build robust and more complex, data-driven desktop applications using the .NET technologies. Coursework emphasizes advanced topics, such as generics, extension methods, linear data structures, delegates, asynchronous programming, parallel programming, advanced GUI, Entity Framework core, ML.NET framework, etc. The language of instruction is C#."
        "COMP-214" -> "Advanced Database Concepts\nThis course is intended to expand the student’s knowledge of business databases using data RDBMS and NoSQL driven systems. The course introduces students to the steps required to install and configure a database server and development system. Then, it expands the students’ knowledge of SQL by introducing more complex syntax than that covered in the first database course. Topics covered include advanced SQL queries, PLSQL, advanced data and table manipulation commands, basic security, triggers, functions, procedures, and packages, NoSQL document management, CRUD operations and data queries, indexing and aggregation techniques. The course will include a project to develop the database back-end for a “commercial” web application."
        "COMP-216" -> "Networking for Software Developers\nLearners in this course will gain hands-on experience by applying knowledge of network protocols and components to the development and maintenance of software applications. Coursework emphasizes network stacks, socket-based network applications, software-defined networks, and developing client applications that interface with various intelligent devices."
        "COMP-231" -> "Software Development Project I\nThis is the capstone course for Software Engineering Technician program and the first software development project course for Software Engineering Technology, Health Informatics Technology, and Game - Programming programs. The students are required to work in teams to design, implement, and document an application or a component for a hypothetical organization. This enables the student to simulate the activities of the software engineering processes using a variety of collaborative tools used in the computer industry."
        "COMP-247" -> "Supervised Learning\nIn this course, students will be introduced to supervised learning techniques and algorithms. Coursework covers the following algorithms: linear regression, logistic regression, decision trees, bayesian learning, support vector machines, sequence learning, k-nearest neighbors, and ensemble techniques. The concepts of underfitting, overfitting, cross-validation, and kernel methods will be covered throughout the course. Students will practice building an end-to-end supervised learning project."
        "COMP-254" -> "Data Structures and Algorithms\nBuilding on fundamentals of Object-Oriented programming, this course exposes the students to algorithms and data structures. Students will analyze, evaluate and apply appropriate data structures & algorithms for the implementation of a software system. Coursework emphasizes the classical data structures, basic algorithm design, common operations on data structures, and the use of mathematical techniques to analyze the efficiency of the various algorithms. The languages of instruction are Java and Python (optional)."
        "COMP-304" -> "Mobile Apps Development\nIn this mobile apps course, students will gain hands-on experience in developing and deploying mobile applications on the Android platform. Coursework emphasizes how to create advanced Graphical User Interfaces (GUIs), handle events, access remote services, store and retrieve data on the device, display maps, and use other Android APIs. Android Studio will be used to create a variety of mobile applications."
        "COMP-311" -> "Software Testing and Quality Assurance\nThis course explores the goals of quality assurance and quality control activities performed during the life cycle of a software product. It focuses on integrating test processes with agile software development methodologies. Practical exercises give experience of design, specification, execution of tests plus test automation using tools through a mixture of instructor-directed exercises and student research leading to knowledge sharing."
        "COMP-318" -> "Developing UI for Software Devices\nThis course will cover developing and testing software systems that interface with various smart devices.  Students will gain hands-on experience by applying machine learning algorithms to automate various tasks as well as develop and deploy various conversational user interfaces. Areas of application include IoT devices, wearables, and autonomous cars."
        "EMPS-101" -> "Employment Skills\nIn Employment Skills 1 students will learn the ability to seek career opportunities and effectively market their knowledge, skills and abilities tailored to these opportunities. Students will identify and catalog work and/or voluntary experience, education and skills as employable assets and leverage these to obtain suitable employment that is consistent with their career plans and goals. This is accomplished by the following strategies:\n" +
                "\n" +
                "a) Prepare a Curriculum Vitae (CV)/Resume based on job-research relevant to students’ respective programs\n" +
                "\n" +
                "b) Use of social media\n" +
                "\n" +
                "c) Prepare a career portfolio.\n" +
                "\n" +
                "d) Attend a simulated/mock job interview scenario\n" +
                "\n" +
                "e) Active assistance of Centennial College Career Services\n" +
                "\n" +
                "f) Apply strategies to grow and excel on the job"
        "GNED" -> "General Education Elective\nSelect an elective course from your area of study."
        "MATH-210" -> "Linear Algebra and Statistics\nThis course contains topics in Linear Algebra and Statistics. Linear algebra topics include operations with matrices, inverses, determinants, and vectors. Statistics topics include descriptive statistics, probability distributions as well as inferential statistics including hypothesis testing. Students will also use software applications in solving relevant problems."
        "ENGL-253" -> "Advanced Business Communications\nENGL-253 is a senior level English course that explores the written and oral communication tasks that people in accounting and related fields encounter at work. It is intended for students who have mastered basic essay-writing skills (COMM-170 level). Its emphasis is on the strategies and formats that lead to effective communication: writing the solution, packaging the solution, and presenting the solution. Writing formats studied include letters, memoranda and reports. Instruction and practice in informal and formal public speaking are also provided. Students are presented with problem-solving tasks that will yield a variety of \"products\": identifying problems, framing potential solutions, resolving problems, and presenting the results of their research in clear and effective ways."
        "CNET-307" -> "IT Project Management\nStudents are taught the concepts and basic functions of Project Management, and the integration of these concepts and functions into a coherent project management system. Also, role of the project manager and the project management team in implementing and controlling projects. Further, the Project Management Body of Knowledge PMBOK® as defined by the Project Management Institute PMI and its application to Project Management.\n" +
                "CNET307 may be delivered in on-line mode."

        else -> ("Composem ipsum color sit lazy, " +
                "padding theme elit, sed do bouncy. ").repeat(4)
    }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = contentText,
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }

    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Group12_COMP304Sec003_Lab04_Ex2Theme {
        OnboardingScreen(
            onAISoftwareEngineeringClicked = {},
            onSoftwareEngineeringTechnicianClicked = {},
            onSoftwareEngineeringTechnologyClicked = {},
        )
    }
}

@Preview
@Composable
fun MyAppPreview() {
    Group12_COMP304Sec003_Lab04_Ex2Theme {
        MyApp(Modifier.fillMaxSize())
    }
}