"""
HACKERRANK: https://www.hackerrank.com/challenges/correlation-and-regression-lines-6/problem?isFullScreen=true
Here are the test scores of 10 students in physics and history:

Physics Scores  15  12  8   8   7   7   7   6   5   3
History Scores  10  25  17  11  13  17  20  13  9   15
Compute Karl Pearson’s coefficient of correlation between these scores.
Compute the answer correct to three decimal places.

Output Format

In the text box, using the language of your choice, print the floating point/decimal value required. Do not leave any leading or trailing spaces.

For example, if your answer is 0.255. In python you can print using

print("0.255")
This is NOT the actual answer - just the format in which you should provide your answer.
"""

physics_scores = [15,12,8,8,7,7,7,6,5,3]
history_scores = [10,25,17,11,13,17,20,13,9,15]

# The goal is to see if there is a correlation between students performance in the two subjects
# we use sklearn for simplicity 

from scipy.stats import pearsonr

stat, p = pearsonr(physics_scores,history_scores)

print(f"The correlation is {stat} with a p-value of {p}")

# Slight positive trend with a large p value, meaning it's likely chance

