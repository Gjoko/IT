using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System;
using System.Linq;

namespace zad3.Pages
{
    [IgnoreAntiforgeryToken(Order = 1001)]
    public class guessNumberModel : PageModel
    {
        [FromQuery(Name = "operand1")]
        public string operand1 { get; set; }
        public int result { get; set; }
        public bool isValid { get; set; }
        public void OnGet()
        {
            int imaginedNumber = 3;
            isValid = false;
            int operand1Value = 0;
            if(isOperandValid(operand1, operand1Value))
            {
                operand1Value = int.Parse(operand1);
                isValid = true;
                result = operand1Value - imaginedNumber;
            }
        }

        public void OnPost(int operand)
        {
            int imaginedNumber = 3;
            isValid = true;
            result = operand - imaginedNumber;
        }

        public bool isOperandValid(string operand, int value)
        {
            return !string.IsNullOrEmpty(operand1) &&
                int.TryParse(operand,out value) ;
        }

    }
}
