$(document).ready(function()
{
    loadStudents();

    $('#student-form').on('submit', function(event)
    {
        event.preventDefault();
        const student =
            {
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            middleName: $('#middleName').val(),
            dateOfBirth: $('#dateOfBirth').val(),
            group: $('#group').val()
        };
        addStudent(student);
    });

    $(document).on('click', '.delete-btn', function()
    {
        const id = $(this).data('id');
        deleteStudent(id);
    });

    function loadStudents()
    {
        $.ajax(
            {
            url: '/students',
            method: 'GET',
            success: function(students)
            {
                $('#student-table tbody').empty();
                students.forEach(function(student)
                {
                    $('#student-table tbody').append(`
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.firstName}</td>
                            <td>${student.lastName}</td>
                            <td>${student.middleName}</td>
                            <td>${student.dateOfBirth}</td>
                            <td>${student.group}</td>
                            <td><button class="delete-btn" data-id="${student.id}">Delete</button></td>
                        </tr>
                    `);
                });
            }
        });
    }

    function addStudent(student)
    {
        $.ajax(
            {
            url: '/students',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(student),
            success: function()
            {
                loadStudents();
                $('#student-form')[0].reset();
            }
        });
    }

    function deleteStudent(id)
    {
        $.ajax({
            url: `/students/${id}`,
            method: 'DELETE',
            success: function()
            {
                loadStudents();
            }
        });
    }
});