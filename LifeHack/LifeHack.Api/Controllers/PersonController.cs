using LifeHack.Domain.Models;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using System.Net.Http;
using System.Threading.Tasks;

namespace LifeHack.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PersonController : ControllerBase
    {
        private readonly IHttpClientFactory _clientFactory;

        public PersonController(IHttpClientFactory clientFactory)
        {
            this._clientFactory = clientFactory;
        }

        [HttpPost]
        public async Task<Person> Post(Person model)
        {
            var request = new HttpRequestMessage(HttpMethod.Get, "http://localhost:8080/person");
            request.Headers.Add("User-Agent", "HttpClientFactory-Sample");
            request.Method = HttpMethod.Post;
            request.Content = new StringContent(JsonConvert.SerializeObject(model));
            var client = _clientFactory.CreateClient();
            var response = await client.SendAsync(request);
            var goal = await response.Content.ReadAsAsync<Person>();
            return goal;
        }
    }
}