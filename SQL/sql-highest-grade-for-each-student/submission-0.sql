select student_id, exam_id, score
from (
    select student_id, exam_id, score,
    row_number() over (
        partition by student_id
        order by score desc, exam_id asc
    ) as rn 
    from exam_results
) t 
where t.rn = 1
order by student_id;