using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Threading.Tasks;

namespace LifeHack.Api.Controllers
{
    /// <summary>
    /// Fetches goals from the main Data Api
    /// </summary>
    [Route("api/[controller]")]
    [ApiController]
    public class GoalsController : ControllerBase
    {

        private readonly IHttpClientFactory _clientFactory;

        public GoalsController(IHttpClientFactory clientFactory)
        {
            this._clientFactory = clientFactory;
        }
        /// <summary>
        /// Gets the first Goal with the sequence=1
        /// </summary>
        /// <returns>The main Goal with child three object Goals</returns>

        [HttpGet]
        public async Task<Goal> Get()
        {
            var request = new HttpRequestMessage(HttpMethod.Get, "http://localhost:8080/goal/?id=1");
            var client = _clientFactory.CreateClient();
            var response = await client.SendAsync(request);
            var responseObject = await response.Content.ReadAsAsync<Goal>();
            return responseObject;
        }
    }
}
