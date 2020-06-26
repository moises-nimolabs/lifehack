using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Threading.Tasks;

namespace LifeHack.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GoalsController : ControllerBase
    {

        private readonly IHttpClientFactory _clientFactory;

        public GoalsController(IHttpClientFactory clientFactory)
        {
            this._clientFactory = clientFactory;
        }

        [HttpGet]
        public async Task<Goal> Get()
        {
            var request = new HttpRequestMessage(HttpMethod.Get, "http://localhost:8080/goal/?id=18");
            request.Headers.Add("User-Agent", "HttpClientFactory-Sample");
            var client = _clientFactory.CreateClient();
            var response = await client.SendAsync(request);
            var goal = await response.Content.ReadAsAsync<Goal>();
            return goal;
        }
    }
}
