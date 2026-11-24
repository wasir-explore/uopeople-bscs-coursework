---
inclusion: always
---

# CS 1102-01 Programming 1 (Term 3, AY2027-T2): Instructor Feedback

**Instructor:** Ruchi Chopra (ruchi.chopra@uopeople.edu)

This file records graded feedback for CS 1102-01 and the rules that follow from it. Apply
these rules in the first draft of every later discussion post, peer reply, and assignment.

## Graded results

| Item | Score | Percent |
|---|---|---|
| Discussion Forum Unit 1 | 97.25 / 100 (4.86 / 5) | 97.25 % |

## Unit 1 Discussion Forum: feedback received

The instructor wrote (paraphrased) that the post was a good effort and addressed the main
areas, but it needed more detail to be complete:

1. **Input validation needed a demonstration.** The post explained `hasNextDouble()` in
   prose only. The instructor wanted a short program that handles invalid entries, such as
   text typed where a number is expected, using an appropriate validation technique.
2. **Typecasting needed a Java example.** The post described implicit widening
   (`int * double`) and explicit narrowing (`(int)` truncation, `Math.round()`) in prose
   only. The instructor wanted a Java snippet showing how implicit and explicit typecasting
   keep expense calculations accurate.
3. **Use properly formatted code blocks.** Code snippets in fenced code blocks improve
   readability and presentation.

## Rules for CS 1102-01 work going forward

- **Show, don't only tell.** Whenever a post explains a programming concept (validation,
  casting, loops, methods, exceptions, and so on), include a short Java snippet that
  demonstrates it. A prose explanation alone costs points even when it is correct.
- **Input validation:** demonstrate a small working program that rejects bad input (for
  example, a loop with `hasNextDouble()` and `scanner.next()` to discard the bad token, or
  a `try`/`catch` for `InputMismatchException`), not just a sentence naming the method.
- **Typecasting:** show implicit widening and explicit narrowing side by side in code, tied
  to the scenario in the prompt (such as expense totals), and show the effect on the result.
- **Format code in fenced blocks** with the language tag (```` ```java ````), as plain text.
  Never use screenshots of code or output.
- **Verify code by running it.** Compile and run every snippet before including it. Any
  output shown must be the real output of that exact code (see the no-fabrication rule in
  `assignment-writing-rules.md`).
- **Completeness over brevity.** Check the prompt for each requested item and make sure
  each one has both an explanation and, where it applies, a code example. Check the word
  limit in the prompt first. If code blocks are not counted toward the limit, say so
  before relying on it, since this has been confirmed only for CS 1101-01 (see
  `cs1101-term2-instructor-rules.md`) and not yet for this instructor.
